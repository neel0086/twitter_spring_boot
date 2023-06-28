package com.tweet.service;

import com.tweet.Mapper.TweetMapper;
import com.tweet.Mapper.UserMapper;
import com.tweet.dto.TweetDto;
import com.tweet.dto.UserDto;
import com.tweet.model.Tweet;
import com.tweet.model.User;
import com.tweet.repository.TweetRepository;
import com.tweet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// UserService.java
@Service
public class UserService {
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public UserService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public UserDto createUser(UserDto userDTO) {
        User user = new User();
        user.setTweets(new ArrayList<>());
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    public TweetDto createTweet(Long userId, TweetDto tweetDto) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Create a new Tweet
            Tweet tweet = new Tweet();
            tweet.setTimestamp(LocalDateTime.now());
            tweet.setContent(tweetDto.getContent());
            tweet.setUser(user);
            // Set other tweet attributes

            Tweet savedTweet = tweetRepository.save(tweet);
            return TweetMapper.toDTO(savedTweet);
        }
        return null;
    }

    public List<TweetDto> getTweetsByUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Tweet> tweets = user.getTweets();
            return tweets.stream().map(TweetMapper::toDTO).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public TweetDto getTweetById(Long userId, Long tweetId) {
        Optional<Tweet> optionalTweet = tweetRepository.findById(tweetId);
        if (optionalTweet.isPresent()) {
            Tweet tweet = optionalTweet.get();
            if (tweet.getUser().getId().equals(userId)) {
                return TweetMapper.toDTO(tweet);
            }
        }
        return null;
    }

    public TweetDto updateTweet(Long userId, Long tweetId, TweetDto tweetDTO) {
        Optional<Tweet> optionalTweet = tweetRepository.findById(tweetId);
        if (optionalTweet.isPresent()) {
            Tweet tweet = optionalTweet.get();
            if (tweet.getUser().getId().equals(userId)) {
                tweet.setContent(tweetDTO.getContent());
                Tweet savedTweet = tweetRepository.save(tweet);
                return TweetMapper.toDTO(savedTweet);
            }
        }
        return null;
    }

    public boolean deleteTweet(Long userId, Long tweetId) {
        Optional<Tweet> optionalTweet = tweetRepository.findById(tweetId);
        if (optionalTweet.isPresent()) {
            Tweet tweet = optionalTweet.get();
            if (tweet.getUser().getId().equals(userId)) {
                tweetRepository.delete(tweet);
                return true;
            }
        }
        return false;
    }
}


