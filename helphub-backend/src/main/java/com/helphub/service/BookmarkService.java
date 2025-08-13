package com.helphub.service;

import com.helphub.dto.BookmarkDto;
import com.helphub.entity.BookMark;

import java.util.List;

public interface BookmarkService {

    BookmarkDto addBookmark(Long userId,Long postId);

    List<BookmarkDto> getBookmarkByUserId(Long userId);

    List<BookmarkDto> getAllBookmarkByPostId(Long postId);

    void removeBookmark(Long userId,Long postId);

    boolean isPostBookmarkedByUser(Long userId,Long postId);


}
