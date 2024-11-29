package com.example.hobiday_backend.domain.feed.dto;
import com.example.hobiday_backend.domain.feed.entity.FeedFile;
import com.example.hobiday_backend.domain.feed.entity.HashTag;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
public class FeedReq {
    @Schema(description = "피드 내용")
    private String content;

    @Schema(description = "피드 주제")
    private String topic;

    @Schema(description = "피드 파일 URL 리스트")
    private List<String> fileUrls;

    @Schema(description = "피드 해시태그")
    private List<String> hashTags;

    // 공연 정보 ex) 매직쇼 더 라이브 (춘천)
}

