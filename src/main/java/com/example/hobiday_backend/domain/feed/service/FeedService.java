package com.example.hobiday_backend.domain.feed.service;

import com.example.hobiday_backend.domain.feed.dto.FeedReq;
import com.example.hobiday_backend.domain.feed.dto.FeedRes;
import com.example.hobiday_backend.domain.feed.entity.Feed;
import com.example.hobiday_backend.domain.feed.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FeedService {
    private final FeedRepository feedRepository;

    public List<FeedRes> getAllFeeds(FeedReq feedReq) {
        return null;
    }

    public FeedRes getFeed(Long id) {
        return null;
    }

    // 게시글 전체 목록 조회
/*    @Transactional(readOnly = true)
    public List<FeedRes> getFeedsAllFeeds(FeedReq feedReq) {
        List<Feed> feeds = feedRepository.findAll();
        return feeds.stream()
                .map(feed -> FeedRes.builder())

    }*/

    // 특정 게시물 조회
}
