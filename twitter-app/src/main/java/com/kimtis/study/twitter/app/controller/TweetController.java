package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.domain.model.Tweet;
import com.kimtis.study.twitter.domain.repository.TweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TweetController {

    private TweetRepository tweetRepository;

    @GetMapping("/tweet")
    public String getAllTweets (){

        return "hello n";
    }

    @PostMapping("/tweet")
    public String postTweet(@RequestBody Tweet tweet){

        return tweet.toString();
    }

    @GetMapping("/tweet/{tweetId}")
    public long getTweet(@PathVariable("tweetId")long tweetId){
        return tweetId;
    }


}
