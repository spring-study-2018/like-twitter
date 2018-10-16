package com.kimtis.study.twitter.domain.service;

import com.kimtis.study.twitter.domain.model.Member;
import com.kimtis.study.twitter.domain.model.UserDetail;
import com.kimtis.study.twitter.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findById(s);

        try {
            if (member.isPresent()) {

                List<String> roles = new ArrayList<>();
                roles.add("user");
                return UserDetail.builder()
                        .memberId(member.get().getMemberId())
                        .id(member.get().getId())
                        .password(member.get().getPassword())
                        .displayName(member.get().getDisplayName())
                        .email(member.get().getEmail())
                        .createdAt(member.get().getCreatedAt())
                        .roles(roles)
                        .build();
            } else {
                System.out.println("no user");
                throw new UsernameNotFoundException(String.format("Username[%s] not found", s));
            }
        }catch (Exception ex) {
            throw new UsernameNotFoundException(String.format("Username[%s] not found", s));
        }
    }

    public Member register(Member member) throws AccountException {
        if ( memberRepository.countById(member.getId()) == 0){
            //password encoding
//            member.setPassword(passwordEncoder.encode(member.getPassword()));
            return memberRepository.save(member);
        } else {
            throw new AccountException(String.format("Username[%s] already taken.", member.getId()));
        }
    }

    public Member findByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findById( id );
        if ( member.isPresent() ) {
            return member.get();
        } else {
            throw new UsernameNotFoundException(String.format("Username[%s] not found", id));
        }

    }
}
