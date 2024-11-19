package com.alibou.example;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolid
) {
}
