package com.example.hobiday_backend.domain.follow.controller;

import com.example.hobiday_backend.domain.follow.service.FollowService;
import com.example.hobiday_backend.global.jwt.TokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;
    private final TokenProvider tokenProvider;

    @Operation(summary = "팔로우 기능", description = "사용자가 로그인 후 받은 인증 토큰과 팔로우 하고자 하는 사용자의 id를 전달하여 해당 사용자를 팔로우 합니다.")
    @GetMapping("/follow")
    public ResponseEntity<String>  follow(@RequestParam(value = "token")
                                          @Parameter(description = "사용자 인증 토큰", required = true) String token,
                                          @RequestParam
                                          @Parameter(description = "팔로우 할 사용자의 id", required = true) Long followingId) {

        Long followerId = tokenProvider.getMemberId(token);

        try {
            followService.follow(followingId, followerId);
            return ResponseEntity.ok().body("success");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("fail");
        }
    }

//    @Operation(summary = "언팔로우 기능", description = "사용자가 로그인 후 받은 인증 토큰과 언팔로우 하고자 하는 사용자의 id를 전달하여 해당 사용자를 언팔로우 합니다.")
//    @DeleteMapping("/unfollow")
//    public ResponseEntity<String> unfollow(@RequestParam(value = "token")
//                                           @Parameter(description = "사용자 인증 토큰", required = true) String token,
//                                           @RequestParam
//                                           @Parameter(description = "언팔로우 할 사용자의 id", required = true) Long followingId) {
//
//        Long followerId = tokenProvider.getMemberId(token);
//
//        try {
//            followService.unfollow(followingId, followerId);
//            return ResponseEntity.ok().body("success");
//        } catch (Exception e) {
//            return ResponseEntity.status(400).body("fail");
//        }
//    }

}
