package com.example.hobiday_backend.domain.feed.dto;

import com.example.hobiday_backend.domain.feed.entity.HashTag;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class FeedRes {
    private String contents;
    private String profileName;
    private List<HashTag> hashTag;
    private int likeCount;
    private boolean isLiked;
}
