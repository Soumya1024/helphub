package com.helphub.repository;

import com.helphub.entity.BookMark;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<BookMark,Long> {

    List<BookMark> findByUser(User User);

    Optional<BookMark> findByUserAndPost(User user, Post post);

    void deleteByUserAndPost(User user,Post post);

    List<BookMark> findByPost(Post post);
}
