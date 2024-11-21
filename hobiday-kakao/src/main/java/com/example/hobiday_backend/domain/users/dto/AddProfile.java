package com.example.hobiday_backend.domain.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddProfile {
    public String profileName;
    public String profileGenre;
}
