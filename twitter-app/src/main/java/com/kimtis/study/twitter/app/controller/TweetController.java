package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.domain.repository.PostsJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

    @Autowired
    PostsJdbcRepository postsJdbcRepository;

    @PostMapping(path = "/posts/post")
    public String post(){
        return "post";
    }


    @PostMapping(path = "/posts/delete")
    public String delete(){
        return "";
    }


    @PostMapping(path = "/posts/update")
    public String update(){
        return "";
    }

    @GetMapping("/posts/get/all")
    public String getAll(){
        return postsJdbcRepository.get();
    }

    @GetMapping("/posts/get/{tweetId}")
    public String getTweeId(){
        return "";
    }
}
