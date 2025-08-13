package com.helphub.controller;


import com.helphub.dto.PostDto;
import com.helphub.entity.Post;
import com.helphub.maper.PostMap;
import com.helphub.service.PostService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helphub/posts")
@AllArgsConstructor
public class PostController {

    public final PostService postService;


    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){


        PostDto savedPost=postService.createPost(postDto);

        return ResponseEntity.ok(savedPost);
    }



    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Long postId){
        PostDto postDto=postService.getPostById(postId);

        return new ResponseEntity<>(postDto,HttpStatus.FOUND);
    }


    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPost(){

       List<PostDto> posts= postService.getAllPost();

       return ResponseEntity.ok(posts);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<List<PostDto>> getAllPostByUserId(@PathVariable("id") Long userId){

        List<PostDto> posts=postService.getAllPostByUserId(userId);

        return ResponseEntity.ok(posts);
    }



    @PutMapping("/{id}/update")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") Long postId,@RequestBody PostDto postDto){

        PostDto updatedPost=postService.updatePost(postId,postDto);

        return ResponseEntity.ok(updatedPost);
    }



    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long postId){
        postService.deletePost(postId);

        return  ResponseEntity.ok("Post Deleted");
    }


    @GetMapping("/search")
    public ResponseEntity<List<PostDto>> getPostByTitle(@RequestParam String title){

        List<PostDto> posts=postService.getPostByTitle(title);

        return new ResponseEntity<>(posts,HttpStatus.FOUND);
    }


    @GetMapping("/category")
    public ResponseEntity<List<PostDto>> getPostByCategory(@RequestParam String category){

        List<PostDto> posts=postService.getPostByCategory(category);

        return new ResponseEntity<>(posts,HttpStatus.FOUND);
    }

}
