package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.domain.model.Member;
import com.kimtis.study.twitter.domain.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {
	private final UserDetailService userDetailService;


	@RequestMapping(method = RequestMethod.POST, path = "/register")
	public Member registerMember(@RequestBody @Valid Member member) throws Exception {

		return userDetailService.register(member);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{username}")
	public Member getMember(@PathVariable String username){

		return userDetailService.findByUsername(username);
	}


	@RequestMapping(method = RequestMethod.GET, path = "/me")
	public Member getMember(OAuth2Authentication auth){
		String username = auth.getPrincipal().toString();
		return userDetailService.findByUsername(username);
	}


}
