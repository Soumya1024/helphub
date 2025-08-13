package com.helphub.repository;

import com.helphub.entity.Contribution;
import com.helphub.entity.Post;
import com.helphub.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ContributionRepository extends JpaRepository<Contribution,Long> {

    List<Contribution> findByUser(User user);
    List<Contribution> findByPost(Post post);
}
