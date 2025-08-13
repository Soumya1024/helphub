package com.helphub.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDate;


public record UserDto(Long userId,
                      String name,
                      String email,
                      String password,
                      String role,
                      LocalDate joinDate) {

}
