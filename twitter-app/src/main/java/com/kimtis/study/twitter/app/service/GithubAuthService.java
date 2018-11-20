package com.kimtis.study.twitter.app.service;

import com.kimtis.study.twitter.app.model.oauth.GithubAccessToken;
import com.kimtis.study.twitter.app.model.oauth.GithubUserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
public class GithubAuthService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${social.github.client-id}")
	private String clientId;

	@Value("${social.github.client-secret}")
	private String clientSecret;

	@Value("${social.github.redirect-uri}")
	private String redirectURI;

	@Value("${social.github.scope}")
	private String scope;

	private static final String GITHUB_AUTHORIZE = "https://github.com/login/oauth/authorize";
	private static final String GITHUB_ACCESS_TOKEN = "https://github.com/login/oauth/access_token";

	private static final String GITHUB_USER_API = "https://api.github.com/user";

	private static final long TTL = 30 * 60 * 1000; // 30 min

	// it should be globally unique (even in distributed systems)
	private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public URI githubIdentityEndpoint() {
		return URI.create(
			UriComponentsBuilder.fromUriString(GITHUB_AUTHORIZE)
				.queryParams(identityParams(clientId, redirectURI, scope))
				.toUriString()
		);
	}

	public String getJsonWebToken(String code, String state) {
		GithubAccessToken githubAccessToken = restTemplate.postForObject(
			GITHUB_ACCESS_TOKEN,
			accessTokenParams(clientId, clientSecret, code, state),
			GithubAccessToken.class
		);

		String authorization = String.format("%s %s", githubAccessToken.getTokenType(), githubAccessToken.getAccessToken());

		RequestEntity<Void> requestEntity = RequestEntity.get(URI.create(GITHUB_USER_API))
			.header(HttpHeaders.AUTHORIZATION, authorization)
			.build();

		GithubUserResponse githubUserResponse = restTemplate.exchange(requestEntity, GithubUserResponse.class).getBody();

		// https://tools.ietf.org/html/rfc7519#section-4.1
		return Jwts.builder()
			.setSubject("github " + githubUserResponse.getLogin())
			.setExpiration(new Date(System.currentTimeMillis() + TTL))
			.signWith(key)
			.compact();
	}

	public String parseJsonWebToken(String jwt) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).toString();
	}

	private static MultiValueMap<String, String> identityParams(String clientId, String redirectURI, String scope) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("client_id", clientId);
		params.add("redirect_uri", redirectURI);
		params.add("scope", scope);
		params.add("state", UUID.randomUUID().toString());
		params.add("allow_signup", Boolean.TRUE.toString());
		return params;
	}

	private static MultiValueMap<String, String> accessTokenParams(String clientId, String clientSecret, String code, String state) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("code", code);
		params.add("state", state);
		return params;
	}
}
