package com.example.hobiday_backend.domain.users.repository;

import com.example.hobiday_backend.domain.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email); // email로 사용자 정보 가져옴
}
