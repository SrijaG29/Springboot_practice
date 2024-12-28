package com.example.employee.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository  extends JpaRepository<EmployeeEntity,Integer> {
    EmployeeEntity findByName(String name);
}
