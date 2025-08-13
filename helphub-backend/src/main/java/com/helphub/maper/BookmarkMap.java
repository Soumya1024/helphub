package com.helphub.maper;

import com.helphub.dto.BookmarkDto;
import com.helphub.entity.BookMark;
import com.helphub.entity.Post;
import com.helphub.entity.User;

public class BookmarkMap {

    public static BookMark toBookmark(BookmarkDto bookmarkDto, User user, Post post){

        return BookMark.builder()
                .user(user)
                .post(post)
                .build();
    }

    public static BookmarkDto toBookmarkDto(BookMark bookMark){

        return new BookmarkDto(
                bookMark.getId(),
                bookMark.getUser().getUserId(),
                bookMark.getPost().getPostId());
    }
}
