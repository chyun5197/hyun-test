package com.example.hobiday_backend.global.error.exception;

import com.example.hobiday_backend.domain.comment.exception.CommentException;
import com.example.hobiday_backend.domain.feed.exception.FeedException;
import com.example.hobiday_backend.global.dto.ErrorRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FeedException.class)
    public ResponseEntity<ErrorRes<Void>> handleFeedException(FeedException e) {
        log.info(e.getMessage(), e);
        return ResponseEntity.status(e.getHttpStatus()).body(ErrorRes.failure(e.getCode(), e.getMessage()));
    }
    @ExceptionHandler(CommentException.class)
    public ResponseEntity<ErrorRes<Void>> handelCommentException(CommentException e) {
        log.info(e.getMessage(),e);
        return ResponseEntity.status(e.getHttpStatus()).body(ErrorRes.failure(e.getCode(), e.getMessage()));
    }

}
