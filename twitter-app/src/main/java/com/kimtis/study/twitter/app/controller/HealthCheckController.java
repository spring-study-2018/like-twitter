package com.kimtis.study.twitter.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HealthCheckController {

    @GetMapping("/hello")
    public String healthCheck() {
        return String.format("Service healthy, %s", new Date());
    }
}
