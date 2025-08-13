package com.helphub.service;

import com.helphub.dto.ContributionDto;
import com.helphub.dto.PostDto;
import com.helphub.entity.User;

import java.util.List;

public interface ContributionService {

    ContributionDto addContribution(ContributionDto contributionDto);

    ContributionDto getContribution(Long id);

    List<ContributionDto> getAllContributions();

    ContributionDto updateContribution(Long id,ContributionDto contributionDto);

    void deleteContribution(Long id);

    List<ContributionDto> getAllContributionsByUserId(Long userId);

    List<ContributionDto> getAllContributionByPostId(Long postId);





}
