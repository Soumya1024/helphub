package com.helphub.dto;

import com.helphub.entity.User;

import java.time.LocalDateTime;

public record ContributionDto(Long id,
                              String message,
                              LocalDateTime timestamp,
                               Long user_id,
                              Long post_id) {
}
