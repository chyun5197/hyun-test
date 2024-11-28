package com.example.hobiday_backend.domain.feed.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Picture {
    private String url;         // S3에 업로드된 사진의 URL
    private String fileName;    // 파일명
    private long fileSize;      // 파일 크기
    private String contentType; // 파일 타입 (예: image/png)
}
