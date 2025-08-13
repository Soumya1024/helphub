package com.helphub.service;

import com.helphub.dto.CommentDto;
import com.helphub.entity.Comment;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import com.helphub.maper.CommentMap;
import com.helphub.repository.CommentRepository;
import com.helphub.repository.PostRepository;
import com.helphub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{

    private UserRepository userRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    @Override
    public CommentDto addComment(CommentDto commentDto) {

        User user=userRepository.findById(commentDto.userId()).orElseThrow(()->new RuntimeException("User Not Found"));

        Post post=postRepository.findById(commentDto.postId()).orElseThrow(()->new RuntimeException("Post not Available"));

        Comment comment= CommentMap.mapToComment(commentDto,user,post);

        Comment savedComment=commentRepository.save(comment);

        return CommentMap.mapToCommentDto(savedComment);
    }

    @Override
    public CommentDto getComment(Long commentId) {

    Comment comment=commentRepository.findById(commentId).orElseThrow(()->new RuntimeException("No Comment Found"));

        return CommentMap.mapToCommentDto(comment);
    }

    @Override
    public List<CommentDto> getAllComment() {

        List<Comment> comments=commentRepository.findAll();

        return comments.stream().map(CommentMap::mapToCommentDto)
                .collect(Collectors.toList()) ;
    }

    @Override
    public CommentDto updateComment(Long commentId,CommentDto commentDto) {

        Comment comment=commentRepository.findById(commentId).orElseThrow(()->new RuntimeException("Comment Not Available"));

        if(commentDto.content()!=null) {
            comment.setContent(commentDto.content());
            comment.setTimestamp(LocalDateTime.now());

        }
        else
            throw new RuntimeException("Can not change anything else");
        Comment updated=commentRepository.save(comment);
        return CommentMap.mapToCommentDto(updated);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment=commentRepository.findById(commentId)
                .orElseThrow(()->new RuntimeException("Comment Not Available"));

        commentRepository.delete(comment);
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(Long postId) {

        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post Not Found"));

        List<Comment> comments=commentRepository.findByPost(post);

        return comments.stream()
                .map(CommentMap::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAllCommentsByUserId(Long userId){

        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Does Not Exist"));

        List<Comment> comments=commentRepository.findByUser(user);

        return comments.stream()
                .map(CommentMap::mapToCommentDto)
                .collect(Collectors.toList());
    }
}
