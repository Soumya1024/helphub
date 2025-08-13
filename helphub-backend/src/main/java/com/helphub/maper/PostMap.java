package com.helphub.maper;

import com.helphub.dto.PostDto;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import com.helphub.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDate;


public class PostMap {


    public static Post mapToPost(PostDto postDto, User user) {
        return Post.builder()
                .postId(postDto.postId())           // Long
                .title(postDto.title())             // String
                .description(postDto.description()) // String
                .category(postDto.category())       // String
                .mediaUrl(postDto.mediaUrl())       // String
                .user(user)                         // User object
                .createdAt(postDto.createdAt())     // LocalDate
                .build();
    }


    public static PostDto mapToPostDto(Post post){

        return new PostDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getCategory(),
                post.getMediaUrl(),
                post.getUser().getUserId(),
                LocalDate.now()
        );
    }

}
