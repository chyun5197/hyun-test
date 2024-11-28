package com.example.hobiday_backend.domain.feed.dto;

import com.example.hobiday_backend.domain.comment.entity.Comment;
import com.example.hobiday_backend.domain.feed.entity.HashTag;
import com.example.hobiday_backend.domain.feed.entity.Picture;
import com.example.hobiday_backend.domain.like.entity.Like;
import com.example.hobiday_backend.domain.profile.entity.Profile;
import lombok.Getter;

import java.util.List;

@Getter
public class FeedReq {
    private String content;
    private Profile profile;
    private Picture picture;
    private List<HashTag> hashTags;
    private List<Like> likeList;
    private List<Comment> commentList;
}
