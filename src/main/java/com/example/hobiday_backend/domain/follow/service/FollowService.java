package com.example.hobiday_backend.domain.follow.service;

import com.example.hobiday_backend.domain.follow.dto.response.FollowResponse;
import com.example.hobiday_backend.domain.follow.entity.Follow;
import com.example.hobiday_backend.domain.follow.repository.FollowRepository;
import com.example.hobiday_backend.domain.profile.entity.Profile;
import com.example.hobiday_backend.domain.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final ProfileRepository profileRepository;
    private final FollowRepository followRepository;

    public void follow(Long followingId,Long followerId) {
        Profile following = profileRepository.findByMemberId(followingId)
                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다."));

        Profile follower = profileRepository.findByMemberId(followerId)
                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다."));

        followRepository.save(Follow.builder()
                .following(following)
                .follower(follower)
                .build());
    }
//
//    public void unfollow(Long followingId, Long followerId) {
//        Follow follow = followRepository.findByFollowingAndFollower(followingId, followerId)
//                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다."));
//
//        followRepository.delete(follow);
//
//    }
}
