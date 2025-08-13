package com.helphub.controller;

import com.helphub.dto.BookmarkDto;
import com.helphub.dto.BookmarkRequest;
import com.helphub.entity.BookMark;
import com.helphub.maper.BookmarkMap;
import com.helphub.service.BookmarkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/helphub/bookmarks")
@AllArgsConstructor
public class BookmarkController {


    private final BookmarkService bookmarkService;


    @PostMapping
    public ResponseEntity<BookmarkDto> addBookmark(@RequestBody BookmarkRequest bookmarkRequest){

        BookmarkDto bookmarkDto=bookmarkService.addBookmark(bookmarkRequest.userId(), bookmarkRequest.postId());

        return  ResponseEntity.ok(bookmarkDto);
    }




    @GetMapping("/{id}")
    public ResponseEntity<List<BookmarkDto>> getBookmarkByUserId(@PathVariable("id") Long userId){


        List<BookmarkDto> bookmarks=bookmarkService.getBookmarkByUserId(userId);


        return new ResponseEntity<>(bookmarks,HttpStatus.FOUND);
    }


    @GetMapping("/post/{id}")
    public ResponseEntity<List<BookmarkDto>> getAllBookmarkByPostId(@PathVariable("id") Long postId){


        List<BookmarkDto> bookmarks=bookmarkService.getAllBookmarkByPostId(postId);

        return new ResponseEntity<>(bookmarks,HttpStatus.FOUND);

    }



    @DeleteMapping("/delete")
    public ResponseEntity<String> removeBookmark(@RequestBody BookmarkRequest bookmarkRequest){
        bookmarkService.removeBookmark(bookmarkRequest.userId(),bookmarkRequest.postId());

        return ResponseEntity.ok("Delete successful");
    }


    @GetMapping("/check")
    public ResponseEntity<Boolean> isPostBookmarkedByUser(@RequestParam Long userId, @RequestParam Long postId){

        boolean b=bookmarkService.isPostBookmarkedByUser(userId,postId);

        return ResponseEntity.ok(b);
    }
}
