package com.helphub.maper;

import com.helphub.dto.UserDto;
import com.helphub.entity.User;

import java.time.LocalDate;


public class UserMap {

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.userId(),
                userDto.name(),
                userDto.email(),
                userDto.password(),
                userDto.role(),
                LocalDate.now());
    }

    public static UserDto mapToUserDto(User user){
        return new UserDto(user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getJoinDate());
    }
}
