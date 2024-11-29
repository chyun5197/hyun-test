package com.example.hobiday_backend.domain.feed.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FeedException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String code;

    public FeedException(FeedErrorCode feedErrorCode) {
        super(feedErrorCode.getMessage());
        this.httpStatus = feedErrorCode.getHttpStatus();
        this.code = feedErrorCode.getCode();
    }

}
