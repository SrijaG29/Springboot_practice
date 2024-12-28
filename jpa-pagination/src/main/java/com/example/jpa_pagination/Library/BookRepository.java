package com.example.jpa_pagination.Library;

import jakarta.persistence.Persistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {

}
