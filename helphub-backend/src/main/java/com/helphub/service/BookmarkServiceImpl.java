package com.helphub.service;

import com.helphub.dto.BookmarkDto;
import com.helphub.entity.BookMark;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import com.helphub.maper.BookmarkMap;
import com.helphub.repository.BookmarkRepository;
import com.helphub.repository.PostRepository;
import com.helphub.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookmarkServiceImpl implements BookmarkService{

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final BookmarkRepository bookmarkRepository;
    @Override
    public BookmarkDto addBookmark(Long userId, Long postId) {

        User user=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User Not Found"));


        Post post=postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post Not Available"));

        BookMark bookMark=new BookMark(user,post);

         BookMark bookMarked=bookmarkRepository.save(bookMark);
        return BookmarkMap.toBookmarkDto(bookMarked);
    }

    @Override
    public List<BookmarkDto> getBookmarkByUserId(Long userId) {

        User user=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));

        return bookmarkRepository.findByUser(user)
                .stream().map(BookmarkMap::toBookmarkDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<BookmarkDto> getAllBookmarkByPostId(Long postId) {

        Post post=postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post not available"));


        return bookmarkRepository.findByPost(post)
                .stream().map(BookmarkMap::toBookmarkDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removeBookmark(Long userId, Long postId) {

        User user=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User Not Found"));


        Post post=postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post Not Available"));


        bookmarkRepository.deleteByUserAndPost(user,post);

    }

    @Override
    public boolean isPostBookmarkedByUser(Long userId, Long postId) {

        User user=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User Not Found"));


        Post post=postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post Not Available"));


        return bookmarkRepository.findByUserAndPost(user,post).isPresent();

    }
}
