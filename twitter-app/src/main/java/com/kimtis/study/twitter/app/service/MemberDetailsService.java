package com.kimtis.study.twitter.app.service;

import com.kimtis.study.twitter.app.auth.security.MemberDetails;
import com.kimtis.study.twitter.domain.model.Member;
import com.kimtis.study.twitter.domain.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class MemberDetailsService implements UserDetailsService {

    private final MemberJpaRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        log.info("loadUserByUsername id={}" , id);
        MemberDetails member = (MemberDetails)memberRepository.findByMemberId(id);
        log.info("loadUserByUsername Member={}" , member);

        if (member == null) {
            throw new UsernameNotFoundException("No user found with userId");
        }

        log.info("get Member Autority={}" , member.getAuthority());


        UserDetails user = new User(member.getId(), member.getPassword(), member.getAuthorities());
        return user;
    }

}
