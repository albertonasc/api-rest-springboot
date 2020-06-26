package com.example.challenge.libary.repositories;

import com.example.challenge.libary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByClientId(Long idClint);
}
