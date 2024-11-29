package com.example.hobiday_backend.domain.feed.controller;

import com.example.hobiday_backend.domain.feed.dto.FeedReq;
import com.example.hobiday_backend.domain.feed.dto.FeedRes;
import com.example.hobiday_backend.domain.feed.service.FeedService;
import com.example.hobiday_backend.domain.member.service.MemberService;
import com.example.hobiday_backend.global.dto.SuccessRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feeds")
public class FeedController {
    private final FeedService feedService;
    private final MemberService memberService;
    //피드 작성
    @PostMapping
    public ResponseEntity<SuccessRes<FeedRes>> createFeed(@RequestBody FeedReq feedReq,
                                                          @RequestHeader("Authorization") String token) {
        // 1. 토큰을 사용해 사용자 ID 가져오기
        Long userId = memberService.getMemberIdByToken(token);
        // 2. 피드 생성
        FeedRes feedRes = feedService.createFeed(feedReq, userId);
        return ResponseEntity.ok(SuccessRes.success(feedRes));
    }

    // 전체 피드 조회
 /*   @GetMapping
    public ResponseEntity<SuccessRes<List<FeedRes>>>*/

}
