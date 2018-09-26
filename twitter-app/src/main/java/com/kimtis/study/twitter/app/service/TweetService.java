package com.kimtis.study.twitter.app.service;

import com.kimtis.study.twitter.domain.model.Tweet;
import com.kimtis.study.twitter.domain.repository.TweetJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TweetService {
	private final TweetJpaRepository tweetRepository;

	public Page<Tweet> findTweets(int page, int size) {
		return tweetRepository.findAll(new PageRequest(page, size));
	}

	public Tweet findTweet(Long tweetId) {
		return tweetRepository.findOne(tweetId);
	}

	public Tweet createTweet(Tweet tweet) {
		return tweetRepository.save(tweet);
	}

	public Tweet updateTweet(Long tweetId, Tweet tweet) {
		tweet.setTweetId(tweetId);
		return tweetRepository.save(tweet);
	}

	public Tweet deleteTweet(Long tweetId) {
		Tweet tweet = tweetRepository.findOne(tweetId);
		tweetRepository.delete(tweetId);
		return tweet;
	}
}
