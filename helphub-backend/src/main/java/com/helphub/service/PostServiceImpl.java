package com.helphub.service;

import com.helphub.dto.PostDto;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import com.helphub.maper.PostMap;
import com.helphub.repository.PostRepository;
import com.helphub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    public final PostRepository postRepository;
    public final UserRepository userRepository;
    @Override
    public PostDto createPost(PostDto postDto) {

        User user=userRepository.findById(postDto.userId())
                .orElseThrow(()->new RuntimeException("User Not Found"));

        Post post= PostMap.mapToPost(postDto,user);
        Post savedPost=postRepository.save(post);

        return PostMap.mapToPostDto(savedPost);
    }

    @Override
    public PostDto getPostById(Long postId) {

        Post post=postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post Not Available"));

        return PostMap.mapToPostDto(post);
    }

    @Override
    public List<PostDto> getAllPost() {

        List<Post> posts=postRepository.findAll();

        return posts.stream().map(PostMap::mapToPostDto).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getAllPostByUserId(Long userId) {

        User user=userRepository
                .findById(userId)
                .orElseThrow(()->new RuntimeException("User Does Not Exist"));

        List<Post> posts=postRepository.findAllByUser(user);


        return posts.stream().map(PostMap::mapToPostDto).collect(Collectors.toList());
    }




    @Override
    public PostDto updatePost(Long postId, PostDto postDto) {

        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post Not Available"));


        if(postDto.category()!=null)
            post.setCategory(postDto.category());
        if (postDto.description()!=null)
            post.setDescription(postDto.description());
        if(postDto.mediaUrl()!=null)
            post.setMediaUrl(postDto.mediaUrl());

        postRepository.save(post);
        return PostMap.mapToPostDto(post);
    }

    @Override
    public void deletePost(Long postId) {


        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post Not Available"));

        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getPostByTitle(String title) {

        List<Post> posts=postRepository.findByTitleContainingIgnoreCase(title);
        return posts.stream()
                .map(PostMap::mapToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostByCategory(String category) {


        List<Post> posts=postRepository.findByCategoryContainingIgnoreCase(category);
        return posts.stream()
                .map(PostMap::mapToPostDto)
                .collect(Collectors.toList());
    }
}
