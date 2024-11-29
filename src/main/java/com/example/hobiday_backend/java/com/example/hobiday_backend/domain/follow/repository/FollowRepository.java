package com.example.hobiday_backend.domain.follow.repository;


import com.example.hobiday_backend.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
//    Optional<Follow> findByFollowingAndFollower(Long followingId, Long followerId);
}
