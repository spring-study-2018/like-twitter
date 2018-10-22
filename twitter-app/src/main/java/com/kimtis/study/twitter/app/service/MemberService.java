package com.kimtis.study.twitter.app.service;

import com.kimtis.study.twitter.domain.model.Member;
import com.kimtis.study.twitter.domain.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberJpaRepository memberRepository;

	public Member findMember(Long memberId) {
		return memberRepository.findOne(memberId);
	}

	public Member findMemberById(String id) {
		return memberRepository.findMemberById(id);
	}

	public Member createMember(Member member) {
		return memberRepository.save(member);
	}

	public Member updateMember(Long memberId, Member member) {
		member.setMemberId(memberId);
		return memberRepository.save(member);
	}

	public Member deleteMember(Long memberId) {
		Member member = memberRepository.findOne(memberId);
		memberRepository.delete(memberId);
		return member;
	}
}
