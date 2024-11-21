package com.example.hobiday_backend.domain.users.controller;

import com.example.hobiday_backend.domain.users.domain.Profile;
import com.example.hobiday_backend.domain.users.dto.AddProfile;
import com.example.hobiday_backend.domain.users.repository.UserRepository;
import com.example.hobiday_backend.domain.users.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final ProfileService profileService;

    @PostMapping("/api/profile")
    public ResponseEntity<?> join(@RequestBody AddProfile addProfile, Principal principal) {
        log.info("시작");
        log.info("로그인 사용자명: " + principal.getName());
//        log.info(user.g;
//        Long id = userRepository.findById(principal.getName())
        profileService.saveProfile(addProfile);
        return ResponseEntity.ok().build();
    }


}
//        log.info("카톡 로그인 닉네임: {}", principal.getName());
//        log.info("전달 받은 장르: {}", addProfile.profileGenre);
//        log.info("전달 받은 프로필명: {}", addProfile.profileName);
//        log.info("저장된 장르: {}", profile.getProfileGenre());
//        log.info("저장된 프로필명: {}", profile.getProfileName());
