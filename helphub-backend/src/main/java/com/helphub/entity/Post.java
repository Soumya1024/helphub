package com.helphub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;


    private String title;

    @Column(length = 1000)
    private String description;

    private String category;//animal,human or other

    private String mediaUrl;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;//link between post and creator

    private LocalDate createdAt;

}
