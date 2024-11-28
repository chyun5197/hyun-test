package com.example.hobiday_backend.domain.feed.controller;

import com.example.hobiday_backend.domain.feed.dto.FeedReq;
import com.example.hobiday_backend.domain.feed.dto.FeedRes;
import com.example.hobiday_backend.domain.feed.service.FeedService;
import com.example.hobiday_backend.global.dto.SuccessRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;

    // 피드 전체 목록 조회
    @GetMapping("/api/feeds")
    public ResponseEntity<SuccessRes<List<FeedRes>>> getFeeds(@RequestBody FeedReq feedReq) {
        List<FeedRes> feeds = feedService.getAllFeeds(feedReq);
        return ResponseEntity.ok(SuccessRes.success(feeds));
    }

    // 피드 게시물 조회
    @GetMapping("/api/feeds/{id}")
    public ResponseEntity<SuccessRes<FeedRes>> getPost(@PathVariable Long id) {
        FeedRes targetFeed = feedService.getFeed(id);
        return ResponseEntity.ok(SuccessRes.success(targetFeed));
    }

    // 게시물 생성

    // 게시물 수정

    // 게시물 삭제

}
