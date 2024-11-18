package com.alibou.example;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentProfileController {

    private final StudentProfileRepository profileRepository;

    public StudentProfileController(StudentProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @PostMapping("/studentprofile")
    public Studentprofile create(
            @RequestBody Studentprofile studentprofile
    ){
        return profileRepository.save(studentprofile);
    }

    @GetMapping("/studentprofile")
    public Optional<Studentprofile> findprofile(
            @PathVariable Integer id
    ){
        return profileRepository.findById(id);
    }
}
