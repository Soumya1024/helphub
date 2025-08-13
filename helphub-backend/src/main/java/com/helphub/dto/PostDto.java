package com.helphub.dto;

import java.time.LocalDate;

public record PostDto(Long postId,
                      String title,
                      String description,
                      String category,
                      String mediaUrl,
                      Long userId,
                      LocalDate createdAt) {
}
