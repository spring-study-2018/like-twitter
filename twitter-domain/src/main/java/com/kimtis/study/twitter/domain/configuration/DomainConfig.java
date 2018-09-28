package com.kimtis.study.twitter.domain.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.kimtis.study.twitter.domain.model")
@EnableJpaRepositories("com.kimtis.study.twitter.domain.repository")
public class DomainConfig {
}
