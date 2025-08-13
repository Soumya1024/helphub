package com.helphub.maper;

import com.helphub.dto.CommentDto;
import com.helphub.entity.Comment;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import com.helphub.repository.CommentRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class CommentMap {

    private CommentRepository commentRepository;

    public static Comment mapToComment(CommentDto commentDto, User user, Post post){

        return new Comment().builder()
                .commentId(commentDto.commentId())
                .content(commentDto.content())
                .user(user)
                .post(post)
                .timestamp(LocalDateTime.now()).build();
    }

    public static CommentDto mapToCommentDto(Comment comment){
        return new CommentDto(
                comment.getCommentId(),
                comment.getContent(),
                comment.getUser().getUserId(),
                comment.getPost().getPostId(),
                comment.getTimestamp());
    }
}
