package com.example.hobiday_backend.domain.like.repository;

import com.example.hobiday_backend.domain.comment.entity.Comment;
import com.example.hobiday_backend.domain.feed.entity.Feed;
import com.example.hobiday_backend.domain.like.entity.Like;
import com.example.hobiday_backend.domain.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    // 특정 Feed와 Profile을 기준으로 Like 검색
    Optional<Like> findByFeedAndProfile(Feed feed, Profile profile);

    // 특정 Comment와 Profile을 기준으로 Like 검색 (나중에 쓰일 거 생각)
    Optional<Like> findByCommentAndProfile(Comment comment, Profile profile);

    // 특정 피드에 대한 좋아요 갯수 조회
    int countByFeedId(Long feedId);

    // Feed에 대한 총 좋아요 수 계산
    int countByFeed(Feed feed);

    // Comment에 대한 총 좋아요 수 계산
    int countByComment(Comment comment);

}
