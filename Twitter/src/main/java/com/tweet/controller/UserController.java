package com.tweet.controller;

import com.tweet.dto.TweetDto;
import com.tweet.dto.UserDto;
import com.tweet.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDTO) {
        UserDto createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @PostMapping("/{userId}")
    public ResponseEntity<TweetDto> createTweet(@RequestBody TweetDto tweetDTO, @PathVariable Long userId) {
        TweetDto createdTweet = userService.createTweet(userId, tweetDTO);
        if (createdTweet != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTweet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @GetMapping("/{userId}/tweets")
    public ResponseEntity<List<TweetDto>> getTweetsByUser(@PathVariable Long userId) {
        List<TweetDto> tweets = userService.getTweetsByUser(userId);
        return ResponseEntity.ok(tweets);
    }

    @GetMapping("/{userId}/tweets/{tweetId}")
    public ResponseEntity<TweetDto> getTweetById(@PathVariable Long userId, @PathVariable Long tweetId) {
        TweetDto tweet = userService.getTweetById(userId, tweetId);
        if (tweet != null) {
            return ResponseEntity.ok(tweet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}/tweets/{tweetId}")
    public ResponseEntity<TweetDto> updateTweet(@PathVariable Long userId, @PathVariable Long tweetId, @RequestBody TweetDto tweetDTO) {
        TweetDto updatedTweet = userService.updateTweet(userId, tweetId, tweetDTO);
        if (updatedTweet != null) {
            return ResponseEntity.ok(updatedTweet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}/tweets/{tweetId}")
    public ResponseEntity<Void> deleteTweet(@PathVariable Long userId, @PathVariable Long tweetId) {
        boolean deleted = userService.deleteTweet(userId, tweetId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}