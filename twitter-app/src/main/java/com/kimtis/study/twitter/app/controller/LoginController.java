package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.app.service.MemberService;
import com.kimtis.study.twitter.domain.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @RequestMapping(path = "/login")
    public String login(){
        log.info("Login View");
        return "";
    }


//    @RequestMapping(method = RequestMethod.GET, path = "/login/process")
//    public String loginProcess(@RequestParam String token){
//        return token;
//    }

    @RequestMapping(method = RequestMethod.POST, path = "/login/fail")
    public String loginFail(){
        return "Login Fail";
    }
}
