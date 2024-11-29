package com.example.hobiday_backend.domain.follow.entity;

import com.example.hobiday_backend.domain.profile.entity.Profile;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower")
    private Profile follower;

    @ManyToOne
    @JoinColumn(name = "following")
    private Profile following;

    @Builder
    public Follow(Profile follower, Profile following){
        this.follower = follower;
        this.following = following;
    }

}
