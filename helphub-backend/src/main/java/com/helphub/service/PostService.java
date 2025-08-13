package com.helphub.service;

import com.helphub.dto.PostDto;
import com.helphub.entity.User;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(Long postId);

    List<PostDto> getAllPost();

    List<PostDto> getAllPostByUserId(Long userId);

    PostDto updatePost(Long postId,PostDto postDto);

    void deletePost(Long postId);

    List<PostDto> getPostByTitle(String title);

    List<PostDto> getPostByCategory(String category);

}
