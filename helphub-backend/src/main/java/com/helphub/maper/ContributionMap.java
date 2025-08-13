package com.helphub.maper;

import com.helphub.dto.ContributionDto;
import com.helphub.entity.Contribution;
import com.helphub.entity.Post;
import com.helphub.entity.User;

import java.time.LocalDate;

public class ContributionMap {

    public static Contribution maptoContribution(ContributionDto contributionDto, User user, Post post){
        return Contribution.builder()
                .id(contributionDto.id())
                .message(contributionDto.message())
                .timestamp(LocalDate.now().atStartOfDay())
                .user(user)
                .post(post)
                .build();

    }

    public static ContributionDto mapToContributionDto(Contribution contribution){
        return new ContributionDto(
                contribution.getId(),
                contribution.getMessage(),
                contribution.getTimestamp(),
                contribution.getUser().getUserId(),
                contribution.getPost().getPostId()

        );
    }
}
