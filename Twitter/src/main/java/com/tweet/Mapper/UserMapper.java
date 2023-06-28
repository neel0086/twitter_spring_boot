package com.tweet.Mapper;

import com.tweet.dto.UserDto;
import com.tweet.model.User;

public class UserMapper {
    public static UserDto toDTO(User user) {
        UserDto userDto = new UserDto();
        userDto.setTweets(user.getTweets());
        return userDto;
    }
}