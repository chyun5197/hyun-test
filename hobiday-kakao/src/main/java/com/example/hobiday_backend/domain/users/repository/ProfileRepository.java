package com.example.hobiday_backend.domain.users.repository;

import com.example.hobiday_backend.domain.users.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
