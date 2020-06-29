package com.example.challenge.libary.controllers;

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
    public ResponseEntity<List<BookDto>> get() {
        return ResponseEntity.ok().body(service.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<BookDto> book = service.getBookById(id);

        return book.isPresent() ?
                ResponseEntity.ok(book.get()) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/client/{clientId}/books")
    public ResponseEntity getBorrowed(@PathVariable("clientId") Long clientId) {
        Optional<BookDto> books = Optional.ofNullable(service.getBorrowedBooks(clientId));

        return books.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(books);
    }

    @PostMapping("/{bookId}/reserve")
    public String post(@PathVariable("bookId") Long bookId) {
        BookDto bookReserved = service.insert(bookId);

        return "Livro reservado com sucesso: " + bookReserved.getId();
    }

    @PutMapping("/{bookId}/return")
    public String put(@PathVariable("bookId") Long bookId) {
        BookDto bookReturned = service.update(bookId);

        return "Livro devolvido com sucesso: " + bookReturned.getId();
    }

}
