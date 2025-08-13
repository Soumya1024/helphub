package com.helphub.controller;


import com.helphub.dto.CommentDto;
import com.helphub.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helphub/comments")
@AllArgsConstructor
public class CommentController {

    public final CommentService commentService;


    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto){

        CommentDto saved=commentService.addComment(commentDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable("id") Long commentId){

        CommentDto commentDto=commentService.getComment(commentId);

        return new ResponseEntity<>(commentDto,HttpStatus.FOUND);
    }


    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComment(){

        List<CommentDto> comments=commentService.getAllComment();

        return new ResponseEntity<>(comments,HttpStatus.FOUND);
    }


    @PutMapping("/{id}/update")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("id") Long commentId,@RequestBody CommentDto commentDto){

        CommentDto update=commentService.updateComment(commentId,commentDto);

        return ResponseEntity.ok(update);
    }



    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId){

        commentService.deleteComment(commentId);

        return ResponseEntity.ok("Message Deleted");
    }


    @GetMapping("/post/{id}")
    public ResponseEntity<List<CommentDto>> getAllCommentsByPostId(@PathVariable("id") Long postId){

        List<CommentDto> comments=commentService.getAllCommentsByPostId(postId);

        return new ResponseEntity<>(comments,HttpStatus.FOUND);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<List<CommentDto>> getAllCommentsByUserId(@PathVariable("id") Long userId){

        List<CommentDto> comments=commentService.getAllCommentsByUserId(userId);

        return new ResponseEntity<>(comments,HttpStatus.FOUND);
    }
}
