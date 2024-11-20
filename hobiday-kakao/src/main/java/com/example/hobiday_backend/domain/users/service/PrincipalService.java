package com.example.hobiday_backend.domain.users.service;

import com.example.hobiday_backend.domain.users.domain.User;
import com.example.hobiday_backend.domain.users.dto.PrincipalDetails;
import com.example.hobiday_backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalService implements UserDetailsService {
    private final UserRepository userRepository;

    // 시큐리티 session => Authentication => UserDetails
    // 여기서 리턴된 값이 Authentication 안에 들어간다.(리턴될때 들어간다.)
    // 그리고 시큐리티 session 안에 Authentication 이 들어간다.
    // 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User findUser = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        if(findUser!=null) {
            return new PrincipalDetails(findUser);
        }
        return null;
    }
}
