package com.example.jpa_pagination.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/books")
    public Page<BookEntity> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "BookName") String sortByValue
    ){
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by(sortByValue));
        return bookRepository.findAll(pageRequest);
    }

}
