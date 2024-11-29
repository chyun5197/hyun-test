package com.example.hobiday_backend.domain.like.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LikeRes {
    private boolean isLiked; // 좋아요 여부
    private int likeCount;   // 좋아요 갯수
}