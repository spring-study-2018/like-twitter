package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.domain.model.Member;
import com.kimtis.study.twitter.domain.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private MemberRepository  memberRepository;

    @GetMapping("")
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }


    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable("memberId")long memberId){
        return memberRepository.findOne(memberId);
    }

    @PostMapping("")
    public Member postMember(@RequestBody @Valid Member member){
        return memberRepository.save(member);
    }
}
