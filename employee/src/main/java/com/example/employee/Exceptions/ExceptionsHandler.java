package com.example.employee.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> employeeNotFoundException(
            EmployeeNotFoundException employeeNotFoundException
    ){
        ExceptionTemplate exceptionTemplate = new ExceptionTemplate(
                employeeNotFoundException.getMessage(),
                employeeNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionTemplate,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DuplicateUserFoundException.class})
    public ResponseEntity<Object> duplicateUserFoundException(
            DuplicateUserFoundException duplicateUserFoundException
    ){
        ExceptionTemplate exceptionTemplate = new ExceptionTemplate(
                duplicateUserFoundException.getMessage(),
                duplicateUserFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionTemplate,HttpStatus.NOT_FOUND);
    }
}
