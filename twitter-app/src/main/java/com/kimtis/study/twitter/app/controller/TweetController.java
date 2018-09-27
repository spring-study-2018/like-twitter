package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.domain.repository.Tweet;
import com.kimtis.study.twitter.domain.repository.TweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class TweetController {

    private TweetRepository tweetRepository;

    @GetMapping("/tweet")
    public String getAllTweets (){

        return "hellp";
    }

    @PostMapping("/tweet")
    public String postTweet(@Valid @RequestBody Tweet tweet){

        return tweet.toString();
    }

    @GetMapping("/tweet/{tweetId}")
    public long getTweet(@PathVariable("tweetId")long tweetId){
        return tweetId;
    }


}
