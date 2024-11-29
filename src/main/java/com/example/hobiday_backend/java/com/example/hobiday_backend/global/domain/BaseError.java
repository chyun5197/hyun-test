package com.example.hobiday_backend.global.domain;

import org.springframework.http.HttpStatus;

public interface BaseError {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}
