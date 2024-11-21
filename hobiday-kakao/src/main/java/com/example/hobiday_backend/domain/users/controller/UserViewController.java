package com.example.hobiday_backend.domain.users.controller;

import com.example.hobiday_backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserViewController {
    private final UserRepository userRepository;

    // 로그인시 oauthlogin(카카오로그인)으로 이동
    @GetMapping("/login")
    public String login(){
        return "oauthLogin";
    }

    // 프로필 정보 입력한 후 홈화면으로 이동
    @GetMapping("/home-home")
    public String home(Model model){
        return "home";
    }

}
