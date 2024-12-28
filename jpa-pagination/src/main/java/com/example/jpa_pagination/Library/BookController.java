package com.example.jpa_pagination.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/create-books")
    public String addBooks(
            @RequestBody List<BookEntity> books
            ){
        bookRepository.saveAll(books);
        return "All books added";
    }
}
