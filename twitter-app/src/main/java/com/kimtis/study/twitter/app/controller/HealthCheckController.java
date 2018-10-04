package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.domain.repository.HealthCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private HealthCheckRepository healthCheckRepository;

    @GetMapping("/hello")
    public String healthCheck() {
        return healthCheckRepository.hello();
    }

}
