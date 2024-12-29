package com.example.employee.Exceptions;

import com.example.employee.EmployeeApplication;
import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }

    public EmployeeNotFoundException(String message,Throwable cause){
        super(message,cause);
    }

}
