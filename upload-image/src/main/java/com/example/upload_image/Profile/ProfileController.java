package com.example.upload_image.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/user/{name}")
    public ProfileEntity userDetails(
            @PathVariable String name
    ){
        return profileRepository.findByName(name);
    }
}
