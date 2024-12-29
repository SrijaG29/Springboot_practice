package com.example.employee.Exceptions;

public class DuplicateUserFoundException extends RuntimeException{
    public DuplicateUserFoundException(String message){
        super(message);
    }

    public DuplicateUserFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
