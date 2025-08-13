package com.helphub.service;

import com.helphub.dto.ContributionDto;
import com.helphub.dto.PostDto;
import com.helphub.entity.Contribution;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import com.helphub.maper.ContributionMap;
import com.helphub.repository.ContributionRepository;
import com.helphub.repository.PostRepository;
import com.helphub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ContributionServiceImpl implements ContributionService{


    public final UserRepository userRepository;
    public final PostRepository postRepository;
    public final ContributionRepository contributionRepository;
    @Override
    public ContributionDto addContribution(ContributionDto contributionDto) {

        User user=userRepository.findById(contributionDto.user_id())
                .orElseThrow(()->new RuntimeException("Account Does not exist"));

        Post post=postRepository.findById(contributionDto.post_id())
                .orElseThrow(()->new RuntimeException("Post Not Found"));


        Contribution contribution=ContributionMap.maptoContribution(contributionDto,user,post);

        Contribution addedContribution=contributionRepository.save(contribution);
        return ContributionMap.mapToContributionDto(addedContribution);
    }

    @Override
    public ContributionDto getContribution(Long id) {

        Contribution contribution=contributionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Contribution does not exist"));


        return ContributionMap.mapToContributionDto(contribution);
    }


    @Override
    public List<ContributionDto> getAllContributions() {

        List<Contribution> contributions=contributionRepository.findAll();

        return contributions.stream()
                .map(ContributionMap::mapToContributionDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContributionDto> getAllContributionsByUserId(Long userId) {

        User user=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User Does Not Exist"));

        List<Contribution> contributions=contributionRepository.findByUser(user);

        return contributions.stream().map(ContributionMap::mapToContributionDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContributionDto> getAllContributionByPostId(Long postId) {

        Post post=postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post Not Available"));


        List<Contribution> contributions=contributionRepository.findByPost(post);


        return contributions.stream()
                .map(ContributionMap::mapToContributionDto)
                .collect(Collectors
                .toList());
    }

    @Override
    public ContributionDto updateContribution(Long id,ContributionDto contributionDto) {

        Contribution contribution=contributionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Contribution Not Exist"));


        if(contributionDto.message()!=null)
            contribution.setMessage(contributionDto.message());
        else
            throw new RuntimeException("You Can't change anything else other than message");


        return ContributionMap.mapToContributionDto(contribution);
    }

    @Override
    public void deleteContribution(Long id) {

        Contribution contribution = contributionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contribution Not Exist"));

        contributionRepository.delete(contribution);

    }



}
