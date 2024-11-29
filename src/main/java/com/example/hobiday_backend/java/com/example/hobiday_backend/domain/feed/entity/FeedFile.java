package com.example.hobiday_backend.domain.feed.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl; // S3 파일 URL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed; // 피드와 연관 관계

    @Builder
    public FeedFile(String fileUrl, Feed feed) {
        this.fileUrl = fileUrl;
        this.feed = feed;
    }
}

