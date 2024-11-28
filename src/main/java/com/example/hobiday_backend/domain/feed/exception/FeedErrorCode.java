package com.example.hobiday_backend.domain.feed.exception;

import com.example.hobiday_backend.global.domain.BaseError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum FeedErrorCode implements BaseError {
    // 에러코드
    FEED_NOT_FOUND(HttpStatus.NOT_FOUND, "FEED_404", "게시물을 찾을 수 없습니다");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
