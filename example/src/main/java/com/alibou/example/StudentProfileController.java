package com.alibou.example;//package com.alibou.example;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//public class StudentProfileController {
//
//    private final StudentProfileRepository profileRepository;
//
//    public StudentProfileController(StudentProfileRepository profileRepository) {
//        this.profileRepository = profileRepository;
//    }
//
////    @PostMapping("/studentprofile")
////    public Studentprofile create(
////            @RequestBody Studentprofile studentprofile
////    ){
////        return profileRepository.save(studentprofile);
////    }
//
//    @PostMapping("/studentprofile")
//    public Studentprofile create(
//            @RequestBody Studentprofile studentprofile
//    ) {
//        // Fetch the student entity from the database using the ID
//        Integer studentId = studentprofile.getStudent().getId();
//        Student existingStudent = StudentRepository.findById(studentId)
//                .orElseThrow(() -> new RuntimeException("Student with ID " + studentId + " not found"));
//
//        // Set the managed Student entity to the StudentProfile
//        studentprofile.setStudent(existingStudent);
//
//        // Save the StudentProfile
//        return profileRepository.save(studentprofile);
//    }
//
//    @GetMapping("/studentprofile")
//    public Optional<Studentprofile> findprofile(
//            @PathVariable Integer id
//    ){
//        return profileRepository.findById(id);
//    }
//}

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentProfileController {

    private final StudentProfileRepository profileRepository;
    private final StudentRepository studentRepository;

    // Constructor-based dependency injection
    public StudentProfileController(StudentProfileRepository profileRepository, StudentRepository studentRepository) {
        this.profileRepository = profileRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/studentprofile")
    public Studentprofile create(@RequestBody Studentprofile studentprofile) {
        // Fetch the student entity from the database using the ID
        Integer studentId = studentprofile.getStudent().getId();
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student with ID " + studentId + " not found"));

        // Set the managed Student entity to the StudentProfile
        studentprofile.setStudent(existingStudent);

        // Save the StudentProfile
        return profileRepository.save(studentprofile);
    }
}

