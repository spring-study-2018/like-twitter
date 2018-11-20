package com.kimtis.study.twitter.app.model.oauth;

import lombok.Data;

@Data
public class GithubUserResponse {
	private Long id;
	private String login;
	private String name;
}
