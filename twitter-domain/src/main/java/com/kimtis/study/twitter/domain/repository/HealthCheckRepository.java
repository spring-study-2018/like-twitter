package com.kimtis.study.twitter.domain.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HealthCheckRepository {

    public String hello(){
        return "Hello";
    }
}
