package com.helphub.repository;

import com.helphub.entity.Post;
import com.helphub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

     List<Post> findAllByUser(User user);

     List<Post> findByTitleContainingIgnoreCase(String tittle);

     List<Post> findByCategoryContainingIgnoreCase(String category);
}
