package com.example.hobiday_backend.domain.feed.entity;

import com.example.hobiday_backend.domain.comment.entity.Comment;
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

    // 주제
    @Column(nullable = false)
    private String topic;

    // 프로필
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    // 피드 사진
    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeedFile> feedFiles = new ArrayList<>();

    // 해시 태그
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
    public Feed(String content,
                String topic,
                Profile profile) {
        this.content = content;
        this.profile = profile;
        this.topic = topic;
    }

    public void incrementLikeCount() {
        this.likeCount++;
    }

    public void decrementLikeCount() {
        this.likeCount--;
    }
}
