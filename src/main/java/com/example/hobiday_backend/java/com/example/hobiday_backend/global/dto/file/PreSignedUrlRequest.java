package com.example.hobiday_backend.global.dto.file;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(description = "프리사인드 url 요청 dto")
public class PreSignedUrlRequest {
    private final String prefix;
    private final String fileName;
}
