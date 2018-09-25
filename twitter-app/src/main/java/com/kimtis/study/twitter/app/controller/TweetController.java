package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.app.Utils.HttpSessionUtils;
import com.kimtis.study.twitter.domain.repository.Tweet;
import com.kimtis.study.twitter.domain.repository.TweetJdbcRepository;
import com.kimtis.study.twitter.domain.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RestController
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    //curl -d "content=test" http://localhost:8080/api/tweet/post
    @PostMapping(path = "/tweet/post")
    public String post(HttpSession session, @RequestParam String content){

//        if ( !HttpSessionUtils.isLogin(session) ) {
//           return "";
//        }

        Tweet tweet = tweetRepository.save(Tweet.builder()
                                            .content(content)
                                            .memberId(2)     /// fix member id, change field.
                                            .build());

        // go to view page
        return "";
    }

    //curl -d "" http://localhost:8080/api/tweet/delete/{tweetId}
    @PostMapping(path = "/tweet/delete/{tweetId}")
    public String delete(@PathVariable Long tweetId){

        tweetRepository.delete(tweetId);

        // go to view page
        return "";
    }

    @GetMapping("/tweet/get/all")
    public String getAll(){

        List<Tweet> tweetList = tweetRepository.findAll();
        return Arrays.toString(tweetList.toArray());
    }

    @GetMapping("/tweet/get/{tweetId}")
    public String getTweeId(@PathVariable Long tweetId){

       Tweet tweet = tweetRepository.findOne(tweetId);
        return tweet.toString();
    }
}
