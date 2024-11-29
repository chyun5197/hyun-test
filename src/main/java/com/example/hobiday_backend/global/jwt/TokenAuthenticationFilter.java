package com.example.hobiday_backend.global.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// 이 필터는 액세스 토큰값이 담긴 Authorization 헤더값을 가져온 뒤 액세스 토큰이 유효하다면 인증 정보를 설정한다.
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;
    private final static String HEADER_AUTHORIZATION = "Authorization";
    private final static String TOKEN_PREFIX = "Bearer";


    // 로그인 후 API 호출(헤더에 토큰 포함)을 처음 시도할때부터 작동하는듯
    // 현재 설정상 "/api/**" 호출시 매번 헤더 토큰을 받아서 인증 통과해야 서비스 응답을 줄 수 있음
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // 요청 헤더의 Authorization 키의 값 조회
        String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);

        // 가져온 값에서 접두사 제거
        String token = getAccessToken(authorizationHeader);

        //가져온 토큰이 유효한지 확인하고, 유효한 때는 인증 정보 설정
        if(tokenProvider.validToken(token)){
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication); // contextHolder에 유저 정보 넣어줌
        }

        filterChain.doFilter(request, response);
    }


    private String getAccessToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)){
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
