package com.helphub.dto;

import java.time.LocalDateTime;

public record CommentDto(Long commentId,
                         String content,
                         Long userId,
                         Long postId,
                         LocalDateTime timestamp) {
}
