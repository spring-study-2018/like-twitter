package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.app.service.MemberService;
import com.kimtis.study.twitter.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	@RequestMapping(method = RequestMethod.GET, path = "/{memberId}")
	public Member findMember(@PathVariable Long memberId) {
		return memberService.findMember(memberId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/id/{id}")
	public Member findMemberById(@PathVariable String id) {
		return memberService.findMemberById(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "")
	public Member createMember(@RequestBody @Valid Member member) {
		return memberService.createMember(member);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{memberId}")
	public Member updateMember(@PathVariable Long memberId, @RequestBody @Valid Member member) {
		return memberService.updateMember(memberId, member);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{memberId}")
	public Member deleteMember(@PathVariable Long memberId) {
		return memberService.deleteMember(memberId);
	}
}
