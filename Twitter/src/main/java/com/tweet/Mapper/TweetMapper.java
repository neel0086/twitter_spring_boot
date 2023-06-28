package com.tweet.Mapper;

import com.tweet.dto.TweetDto;
import com.tweet.model.Tweet;

public class TweetMapper {
    public static TweetDto toDTO(Tweet tweet) {
        TweetDto tweetDTO = new TweetDto();
        tweetDTO.setContent(tweet.getContent());
        return tweetDTO;
    }
}
