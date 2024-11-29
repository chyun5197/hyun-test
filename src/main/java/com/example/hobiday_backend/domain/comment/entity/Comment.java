package com.example.hobiday_backend.domain.comment.entity;

import com.example.hobiday_backend.domain.comment.dto.CommentReq;
import com.example.hobiday_backend.domain.feed.entity.Feed;
import com.example.hobiday_backend.domain.like.entity.Like;
import com.example.hobiday_backend.domain.profile.entity.Profile;
import com.example.hobiday_backend.global.domain.TImeStamped;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends TImeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 댓글 내용
    @Column(nullable = false, length = 2200)
    private String contents;

    //프로필
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    //피드
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    public Comment(String contents, Feed feed, Profile profile) {
        this.contents = contents;
        this.feed = feed;
        this.profile = profile;
    }

    // 댓글 수정
    public void updateContents(String contents) {
        this.contents = contents;
    }

    /*
    // 부모 댓글
    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    //자식 댓글
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> childCommentList = new ArrayList<>();


    // 좋아요 리스트
    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<Like> likeList = new ArrayList<>();
*/

 /*   public Comment(CommentReq commentReq, Feed feed, Profile profile, Comment parentComment) {
        this.contents = commentReq.getContents();
        this.feed = feed;
        this.profile = profile;

        if (parentComment != null && parentComment.getParentComment() != null) {
            throw new RuntimeException("Nested replies are not allowed.");
        }
        this.parentComment = parentComment;
    }*/

}
