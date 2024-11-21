package com.example.hobiday_backend.domain.users.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "profile")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private Long id;
    private String profileName;
    private String profileGenre;

    @Builder
    public Profile(Long id, String profileName, String profileGenre) {
        this.id = id;
        this.profileName = profileName;
        this.profileGenre = profileGenre;
    }
}
