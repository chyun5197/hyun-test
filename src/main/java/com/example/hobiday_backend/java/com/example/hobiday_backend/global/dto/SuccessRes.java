package com.example.hobiday_backend.global.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessRes<T> {
    private String code;
    private String message;
    private T result;

    private final static String SUCCESS_CODE = "200";

    public static <T> SuccessRes<T> success(T result) {
        return SuccessRes.<T>builder()
                .code(SUCCESS_CODE)
                .result(result)
                .build();
    }

    public static <T> SuccessRes<T> success(T result, String message) {
        return SuccessRes.<T>builder()
                .result(result)
                .message(message)
                .code(SUCCESS_CODE)
                .build();
    }

    public static <T> SuccessRes<T> success(String message) {
        return SuccessRes.<T>builder()
                .message(message)
                .code(SUCCESS_CODE)
                .build();
    }
}
