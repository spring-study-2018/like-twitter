package com.kimtis.study.twitter.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan("com.kimtis.study.twitter.domain")
public class ApplicationContextConfig {

}
