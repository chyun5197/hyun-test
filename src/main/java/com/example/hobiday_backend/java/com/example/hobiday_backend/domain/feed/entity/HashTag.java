package com.example.hobiday_backend.domain.feed.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String hashTag;

    @ManyToOne
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Builder
    public HashTag(String hashTag, Feed feed) {
        this.hashTag = hashTag;
        this.feed = feed;
    }
}
