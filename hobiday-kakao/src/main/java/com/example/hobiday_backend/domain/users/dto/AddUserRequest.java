package com.example.hobiday_backend.domain.users.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String nickname;
    private String email;
    private String password;

}
