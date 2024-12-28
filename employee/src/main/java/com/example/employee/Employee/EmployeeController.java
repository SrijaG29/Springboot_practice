package com.example.employee.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRespository employeeRespository;
    private EmployeeEntity employeeEntity;

    @PostMapping("/create-employee")
    public String createEmployee(
            @RequestBody EmployeeEntity employeeEntity
    ){
        employeeRespository.save(employeeEntity);
        return "User created";
    }

    @GetMapping("employee/{name}")
    public EmployeeEntity employeeId(
           @PathVariable String name
    ){
        return  employeeRespository.findByName(name);
    }
}
