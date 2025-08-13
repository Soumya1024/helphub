package com.helphub.controller;


import com.helphub.dto.ContributionDto;
import com.helphub.entity.User;
import com.helphub.repository.UserRepository;
import com.helphub.service.ContributionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helphub/contributions")
@AllArgsConstructor
public class ContributionController {

    private final ContributionService contributionService;
    private final UserRepository userRepository;



    @PostMapping
    public ResponseEntity<ContributionDto> addContribution(@RequestBody ContributionDto contributionDto){
        ContributionDto saved=contributionService.addContribution(contributionDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<ContributionDto> getContribution(@PathVariable("id") Long contId){
        ContributionDto contributionDto=contributionService.getContribution(contId);


        return new ResponseEntity<>(contributionDto,HttpStatus.FOUND);
    }


    @GetMapping
    public ResponseEntity<List<ContributionDto>> getAllContributions(){


        List<ContributionDto> userContributions=contributionService.getAllContributions();


        return ResponseEntity.ok(userContributions);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ContributionDto>> getAllContributionsByUserId(@PathVariable("id") Long userId){


        List<ContributionDto> userContributions=contributionService.getAllContributionsByUserId(userId);

        return ResponseEntity.ok(userContributions);
    }


    @GetMapping("/post/{id}")
    public ResponseEntity<List<ContributionDto>> getAllContributionByPostId(@PathVariable("id") Long postId){


        List<ContributionDto> contributions=contributionService.getAllContributionByPostId(postId);

        return new ResponseEntity<>(contributions,HttpStatus.FOUND);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ContributionDto> updateContribution(@PathVariable("id") Long id,@RequestBody ContributionDto contributionDto){


        ContributionDto updatedContribution=contributionService.updateContribution(id,contributionDto);


        return  ResponseEntity.ok(updatedContribution);
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteContribution(@PathVariable Long id){

        contributionService.deleteContribution(id);

        return ResponseEntity.ok("Deleted Successfully");
    }
}
