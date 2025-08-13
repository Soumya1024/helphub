package com.helphub.service;

import com.helphub.dto.UserDto;
import com.helphub.entity.User;
import com.helphub.maper.UserMap;
import com.helphub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    public final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {


        if(userRepository.existsByEmail(userDto.email())){
            throw new RuntimeException("Email already exist");
        }

        User user=UserMap.mapToUser(userDto);
        User savedUser=userRepository.save(user);

        return UserMap.mapToUserDto(savedUser);
    }


    @Override
    public UserDto getUserById(Long userId) {

        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not Exist"));
        return UserMap.mapToUserDto(user);
    }


    @Override
    public List<UserDto> getAllUsers() {

        List<User> users=userRepository.findAll();
        return users.stream().map(UserMap::mapToUserDto).collect(Collectors.toList());

    }


    @Override
    public void deleteUserById(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
        userRepository.delete(user);
    }

    @Override
    public UserDto updateUser(Long userId,UserDto userDto) {

        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Exist"));

        if(userDto.name() !=null)
            user.setName(userDto.name());
        if(userDto.email() != null)
            user.setEmail(userDto.email());
        if(userDto.password()!=null)
            user.setPassword(userDto.password());
        if ((userDto.role()!=null))
            user.setRole(userDto.role());
        User savedUser=userRepository.save(user);
        return UserMap.mapToUserDto(savedUser);
    }
}
