package com.example.hobiday_backend.domain.feed.dto;

import com.example.hobiday_backend.domain.feed.entity.HashTag;
import com.example.hobiday_backend.domain.feed.entity.Picture;
import com.example.hobiday_backend.domain.like.entity.Like;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class FeedRes {
    private String contents;
    private Picture picture;
    private String profileName;
    private List<HashTag> hashTag;
    private List<Like> likeList;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    private int likeCount;
    private boolean isLiked;
}
