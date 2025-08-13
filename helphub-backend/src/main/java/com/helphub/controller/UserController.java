package com.helphub.controller;


import com.helphub.dto.UserDto;
import com.helphub.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/helphub/users")
public class UserController  {


    public final UserService userService;


    //User create Account Rest Api


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto savedUser=userService.createUser(userDto);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto userDto=userService.getUserById(userId);

        return new ResponseEntity<>(userDto,HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users=userService.getAllUsers();

        return ResponseEntity.ok(users);
    }


    @PutMapping("/{id}/update")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody UserDto userDto){

        UserDto updatedUser=userService.updateUser(userId,userDto);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){

        userService.deleteUserById(userId);

        return ResponseEntity.ok("User deleted");
    }
}
