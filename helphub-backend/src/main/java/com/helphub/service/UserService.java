package com.helphub.service;

import com.helphub.dto.UserDto;
import com.helphub.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long userId);
    void deleteUserById(Long userId);
    UserDto updateUser(Long userId,UserDto userDto);



}
