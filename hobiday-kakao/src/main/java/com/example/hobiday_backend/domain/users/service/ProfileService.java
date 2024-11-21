package com.example.hobiday_backend.domain.users.service;

import com.example.hobiday_backend.domain.users.domain.Profile;
import com.example.hobiday_backend.domain.users.dto.AddProfile;
import com.example.hobiday_backend.domain.users.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Profile saveProfile(AddProfile profile){ //}, Long id){
        return profileRepository.save(Profile.builder()
//                .id(id)
//                .profileName(profile.profileName)
                .profileGenre(profile.profileGenre)
                .build());
    }
}
