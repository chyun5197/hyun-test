package com.example.hobiday_backend.domain.feed.entity;

import com.example.hobiday_backend.domain.comment.entity.Comment;
import com.example.hobiday_backend.domain.feed.dto.FeedReq;
import com.example.hobiday_backend.domain.like.entity.Like;
import com.example.hobiday_backend.domain.profile.entity.Profile;
import com.example.hobiday_backend.global.domain.TImeStamped;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Feed extends TImeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 피드 내용
    @Column(nullable = false)
    private String content;

    // 프로필
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    // 사진
    @Embedded
    private Picture picture;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HashTag> hashTags = new ArrayList<>();

    // 좋아요 갯수 캐싱
    @Column(nullable = false)
    private int likeCount;

    //댓글
    @OneToMany(mappedBy = "feed", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();


    // dto의 값을 엔티티로 바꿔서 저장하기 위한 빌더
    @Builder
    public Feed(FeedReq feedReq/*, User user*/) {
        this.content = feedReq.getContent();
        this.picture = feedReq.getPicture();
        this.hashTags = feedReq.getHashTags();
        this.commentList = feedReq.getCommentList();
        this.profile = feedReq.getProfile();
    }

    public void incrementLikeCount() {
        this.likeCount++;
    }

    public void decrementLikeCount() {
        this.likeCount--;
    }
}
