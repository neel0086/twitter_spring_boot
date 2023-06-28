package com.tweet.dto;

import com.tweet.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TweetDto {
    private String content;
    private LocalDateTime timestamp;
    private User user;
}
