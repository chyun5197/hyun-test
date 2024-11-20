//package com.example.hobiday_backend.domain.users.domain;
//
//import com.example.hobiday_backend.domain.users.dto.PrincipalDetails;
//import lombok.Getter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.List;
//
//@Getter
//public class UserAccount extends PrincipalDetails {
//    private User user;
//    public UserAccount(User user) {
//        super(user.getEmail(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
//        this.user = user;
//    }
//}
