package com.example.hobiday_backend.domain.comment.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommentException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String code;

    public CommentException(CommentErrorCode commentErrorCode) {
        super(commentErrorCode.getMessage());
        this.httpStatus = commentErrorCode.getHttpStatus();
        this.code = commentErrorCode.getCode();
    }
}
