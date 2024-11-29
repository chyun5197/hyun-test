package com.example.hobiday_backend.domain.feed.repository;

import com.example.hobiday_backend.domain.feed.entity.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTag,Long> {
}
