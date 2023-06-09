package com.example.japapp.repository;

import com.example.japapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookById(long id);
    Optional<Book> findBookByTitle(String title);
    List<Book> findAll();
}
