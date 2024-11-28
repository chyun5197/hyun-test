package com.example.hobiday_backend.domain.comment.repository;

import com.example.hobiday_backend.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 생성 시간 기준 오름차순 정렬
    List<Comment> findAllByFeedIdOrderByCreatedTimeAsc(Long feedId);;
}