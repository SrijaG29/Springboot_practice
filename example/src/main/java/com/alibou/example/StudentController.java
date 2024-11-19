package com.alibou.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody StudentDto dto){
        var student = toStudent(dto);
        return repository.save(student);
    }

    private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolid());

        student.setSchool(school);

        return student;
    }

    @GetMapping("/students")
    public List<Student> findallstudent(){
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findstudent(
            @PathVariable("student-id") Integer id
    ){
        return repository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findstudentbyname(
            @PathVariable("student-name") String firstname
    ){
        return repository.findAllByFirstnameContaining(firstname);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
        repository.deleteById(id);
    }


}
