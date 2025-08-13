package com.helphub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contributions")

public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;


    @Builder.Default
    private LocalDateTime timestamp=LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,unique = true)
    private User user;



    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false,unique = true)
    private Post post;

}
