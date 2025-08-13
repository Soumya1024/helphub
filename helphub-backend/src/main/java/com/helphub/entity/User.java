package com.helphub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    private String name;

    @Column(name="email",nullable = false,unique = true)
    private String email;


    private String password;
    private String role;//helper or seeker or both

    @Builder.Default
    private LocalDate joinDate=LocalDate.now();
}
