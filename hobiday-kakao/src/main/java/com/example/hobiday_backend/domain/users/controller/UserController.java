package com.example.hobiday_backend.domain.users.controller;

import com.example.hobiday_backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;


    //테스트용
    @GetMapping("/api/test")
    public ResponseEntity<?> tester(Principal principal,
                                        @AuthenticationPrincipal User user) {
        // 현재 로그인한 사용자 정보 가져오기 (Principal principal, @AuthenticationPrincipal User user) 둘 중 하나 선택
        // 여기서 User는 도메인이 아니라 시큐리티에 있는 org.springframework.security.core.userdetails.User를 import해야함
        log.info("현재 로그인한 사용자명: " + principal.getName()); // 둘 중 하나 선택
        log.info("현재 로그인한 사용자명: " + user.getUsername()); //
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(principal.getName());
    }
}
