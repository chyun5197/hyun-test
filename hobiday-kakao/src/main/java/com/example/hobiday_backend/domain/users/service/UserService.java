package com.example.hobiday_backend.domain.users.service;

import com.example.hobiday_backend.domain.users.dto.AddUserRequest;
import com.example.hobiday_backend.domain.users.domain.User;
import com.example.hobiday_backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .nickname(dto.getNickname())
                .email(dto.getEmail())
//                .password(encoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    public User findByEmail(String email){ // OAuth2에서 제공하는 정보는 유일 값이므로 해당 메서드로 유저 찾을 수 있음
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails findUser = (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        if(findUser!=null) {
            return findUser;
        }
        return null;
    }
}
