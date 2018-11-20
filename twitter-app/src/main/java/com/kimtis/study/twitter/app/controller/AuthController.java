package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.app.service.GithubAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
	private final GithubAuthService githubAuthService;

	@RequestMapping(method = RequestMethod.GET, path = "/github")
	public ResponseEntity githubAuthentication() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(githubAuthService.githubIdentityEndpoint());
		return new ResponseEntity(headers, HttpStatus.MOVED_PERMANENTLY);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/github-callback")
	public String githubAuthenticationCallback(@RequestParam String code, @RequestParam String state) {
		return githubAuthService.getJsonWebToken(code, state);
	}

	// check the json web token
	@RequestMapping(method = RequestMethod.GET, path = "/jwt/{jwt}")
	public String jsonWebToken(@PathVariable String jwt) {
		return githubAuthService.parseJsonWebToken(jwt);
	}
}
