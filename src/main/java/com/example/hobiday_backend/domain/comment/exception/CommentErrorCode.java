package com.example.hobiday_backend.domain.comment.exception;

import com.example.hobiday_backend.global.domain.BaseError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommentErrorCode implements BaseError {
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMENT_404","해당 댓글을 찾을 수 없습니다"),
    COMMENT_UPDATE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "COMMENT_403_UPDATE", "댓글을 수정할 권한이 없습니다"),
    COMMENT_DELETE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "COMMENT_403_DELETE", "댓글을 삭제할 권한이 없습니다");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
