package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.domain.model.Tweet;
import com.kimtis.study.twitter.domain.repository.TweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tweet")
@AllArgsConstructor
public class TweetController {

    private TweetRepository tweetRepository;

    @GetMapping("")
    public List<Tweet> getAllTweets (){
        return tweetRepository.findAll();
    }

    @PostMapping("")
    public Tweet postTweet(@RequestBody @Valid Tweet tweet){
        System.out.println(tweet.getContent());
        return tweetRepository.save(tweet);
    }

    @GetMapping("/{tweetId}")
    public Tweet getTweet(@PathVariable("tweetId")long tweetId){
        return tweetRepository.findOne(tweetId);
    }


}
