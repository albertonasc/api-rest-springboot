package com.example.challenge.libary.services;

import com.example.challenge.libary.controllers.BookDto;
import com.example.challenge.libary.models.Book;
import com.example.challenge.libary.models.BookStatus;
import com.example.challenge.libary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookDto> getBooks() {
        return repository.findAll().stream().map(BookDto::new).collect(Collectors.toList());
    }

    public Optional<BookDto> getBookById(Long id) {
        return repository.findById(id).map(BookDto::new);
    }

    public BookDto getBorrowedBooks(Long clientId) {
        for(Book clientData : repository.findByClientId(clientId)) {
            if(clientData != null) {
                if(clientData.getStatus() == BookStatus.EMPRESTADO) {
                    return new BookDto(clientData);
                } else {
                    throw new RuntimeException("Não existem livros emprestados");
                }
            }
        }

        return null;
    }

    public BookDto insert(Long bookId) {
        Optional<Book> optional = repository.findById(bookId);

        if(optional.isPresent()) {
            Book db = optional.get();
            db.setStatus(BookStatus.EMPRESTADO);
            db.setDateReserve(new Date());

            repository.save(db);

            return new BookDto(db);
        } else {
            throw new RuntimeException("Não foi possivel atualizar o Status");
        }

    }

    public BookDto update(Long bookId) {
        Optional<Book> optional = repository.findById(bookId);

        if(optional.isPresent()) {
            Book db = optional.get();
            db.setDateReturn(new Date());
            db.totalValue(db.getDateReserve(), db.getDateReturn());

            if (db.getValue() == 0.0) {
                db.setStatus(BookStatus.DISPONIVEL);
            }

            repository.save(db);

            return new BookDto(db);
        } else {
            throw new RuntimeException("Não foi possivel atualizar o Status");
        }
    }
}
