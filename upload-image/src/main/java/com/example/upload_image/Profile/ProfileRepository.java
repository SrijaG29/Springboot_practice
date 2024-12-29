package com.example.upload_image.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity,Integer> {
    ProfileEntity findByName(String Name);
}
