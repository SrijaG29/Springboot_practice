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
    public Student post(@RequestBody Student student){
        return repository.save(student);
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
