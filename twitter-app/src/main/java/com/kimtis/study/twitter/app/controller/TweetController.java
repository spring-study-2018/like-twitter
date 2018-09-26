package com.kimtis.study.twitter.app.controller;

import com.kimtis.study.twitter.app.service.TweetService;
import com.kimtis.study.twitter.domain.model.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetController {
	private final TweetService tweetService;

	@RequestMapping(method = RequestMethod.GET, path = "")
	public Page<Tweet> findAllTweets(
		@RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "5") Integer size) {
		return tweetService.findTweets(page, size);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{tweetId}")
	public Tweet findTweet(@PathVariable Long tweetId) {
		return tweetService.findTweet(tweetId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "")
	public Tweet createTweet(@RequestBody @Valid Tweet tweet) {
		return tweetService.createTweet(tweet);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{tweetId}")
	public Tweet updateTweet(@PathVariable Long tweetId, @RequestBody @Valid Tweet tweet) {
		return tweetService.updateTweet(tweetId, tweet);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{tweetId}")
	public Tweet deleteTweet(@PathVariable Long tweetId) {
		return tweetService.deleteTweet(tweetId);
	}
}
