package com.example.hobiday_backend.global.s3.controller;

import com.example.hobiday_backend.global.dto.SuccessRes;
import com.example.hobiday_backend.global.dto.file.PreSignedUrlRequest;
import com.example.hobiday_backend.global.dto.file.PresignedUrlResponse;
import com.example.hobiday_backend.global.s3.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/file")
public class FileController {

    private final FileService fileService;

    @Operation(summary = "Presigned URL 요청", description = "파일 업로드를 위한 presigned URL을 생성하는 API" +
            "\n버킷명/prefix/fileName 위치에 파일 생성")
    @PostMapping
    public ResponseEntity<PresignedUrlResponse> uploadPhoto(@RequestBody PreSignedUrlRequest presignedUrlRequest) {
        // Presigned URL 생성 요청 처리
        PresignedUrlResponse response = fileService.getUploadPresignedUrl(
                presignedUrlRequest.getPrefix(),
                presignedUrlRequest.getFileName()
        );

        // 성공적인 응답을 반환
        return ResponseEntity.ok(response);
    }
}




