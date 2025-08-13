package com.helphub.entity;

import jakarta.persistence.*;
import lombok.*;





@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bookmarks",uniqueConstraints = {
        @UniqueConstraint(columnNames={"user_id","post_id"})})
public class BookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;

    public BookMark(User user, Post post) {
        this.post=post;
        this.user=user;
    }
}
