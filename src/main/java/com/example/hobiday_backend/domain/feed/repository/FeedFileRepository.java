package com.example.hobiday_backend.domain.feed.repository;

import com.example.hobiday_backend.domain.feed.entity.FeedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedFileRepository extends JpaRepository<FeedFile,Long> {
}
