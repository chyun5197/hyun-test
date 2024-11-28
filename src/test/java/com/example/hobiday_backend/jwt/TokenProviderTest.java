package com.example.hobiday_backend.jwt;//package com.example.hobiday_backend.global.jwt;
//
//import io.jsonwebtoken.Jwts;
//import com.example.hobiday_backend.domain.users.repository.UserRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Map;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class TokenProviderTest { // "Bearer" 미포함으로 테스트
//
//    @Autowired
//    private TokenProvider tokenProvider;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private JwtProperties jwtProperties;
//
//    @DisplayName("getUserId(): 토큰으로 유저 ID를 가져올 수 있다.")
//    @Test
//    void getUserId() {
//        // given
//        Long userId = 1L;
//        String token = JwtFactory.builder()
//                .claims(Map.of("id", userId))
//                .build()
//                .createToken(jwtProperties);
//        System.out.println("토큰: " +token);
//        // when
//        Long userIdByToken = tokenProvider.getUserId(token);
//
//        // then
//        assertThat(userIdByToken).isEqualTo(userId);
//    }
//}