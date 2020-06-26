package com.example.challenge.libary.controllers;

import com.example.challenge.libary.models.Book;
import com.example.challenge.libary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> get() {
        List<Book> books = service.getBooks();

        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Book> book = service.getBookById(id);

        return book.isPresent() ?
                ResponseEntity.ok(book.get()) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/client/{id_client}")
    public ResponseEntity getBorrowed(@PathVariable("id_client") Long idClint) {
        List<Book> books = service.getBorrowedBooks(idClint);

        return books.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(books);
    }

    @PostMapping("/{bookId}/reserve")
    public String post(@PathVariable("bookId") Long bookId) {
        Book bookReserved = service.insertReserv(bookId);

        return "Livro reservado com sucesso: " + bookReserved.getId();
    }

}
