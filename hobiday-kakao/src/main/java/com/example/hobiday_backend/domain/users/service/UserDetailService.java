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
//UserDetailsService: 스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스
public class UserDetailService implements UserDetailsService  {
    private final UserRepository userRepository;


    // 맞는지 불확실
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
