package com.helphub.repository;

import com.helphub.entity.Comment;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPost(Post post);

    List<Comment> findByUser(User user);
}
