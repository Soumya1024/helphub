package com.helphub.service;

import com.helphub.dto.CommentDto;
import com.helphub.entity.Comment;

import java.util.List;

public interface CommentService {

    CommentDto addComment(CommentDto commentDto);

    CommentDto getComment(Long commentId);

    List<CommentDto> getAllComment();

    CommentDto updateComment(Long commentId,CommentDto commentDto);

    void deleteComment(Long commentId);

    List<CommentDto> getAllCommentsByPostId(Long postId);

    List<CommentDto> getAllCommentsByUserId(Long userId);
}
