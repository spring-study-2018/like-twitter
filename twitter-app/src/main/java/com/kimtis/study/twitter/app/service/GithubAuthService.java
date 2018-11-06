package com.kimtis.study.twitter.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

	public URI githubIdentityEndpoint() {
		return URI.create(
			UriComponentsBuilder.fromUriString(GITHUB_AUTHORIZE)
				.queryParams(identityParams(clientId, redirectURI, scope))
				.toUriString()
		);
	}

	public String a(String code, String state) {
		return restTemplate.postForObject(
			GITHUB_ACCESS_TOKEN,
			accessTokenParams(clientId, clientSecret, code, state),
			String.class
		);
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
