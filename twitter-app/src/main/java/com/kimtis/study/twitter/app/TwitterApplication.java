package com.kimtis.study.twitter.app;

import com.kimtis.study.twitter.domain.model.Member;
import com.kimtis.study.twitter.domain.model.UserDetail;
import com.kimtis.study.twitter.domain.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.security.auth.login.AccountException;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class TwitterApplication {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public static void main(String[] args) {
        SpringApplication.run(TwitterApplication.class, args);
    }
    @Bean
    CommandLineRunner init(UserDetailService userDetailService) {
        return (evt) -> {
                    try{
                    Member member= Member.builder()
                            .id("asfd")
                            .password("qwer")
                            .displayName("sdfd")
                            .email("we")
                            .createdAt(new Date())
                            .build();

                        userDetailService.register(member);
                    } catch (AccountException e) {
                        e.printStackTrace();
                    }
                };
    }
}
