package com.example.challenge.libary.services;

import com.example.challenge.libary.models.Book;
import com.example.challenge.libary.models.BookStatus;
import com.example.challenge.libary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    public List<Book> getBorrowedBooks(Long idClint) {
        return repository.findByClientId(idClint);
    }

    public Book insertReserv(Book book) {
        Assert.isNull(book.getId(), "Não foi possivel fazer a Reserva");

        Optional<Book> optional = getBookById(book.getId());
        if(optional.isPresent()) {
            Book db = optional.get();
            db.setStatus(BookStatus.EMPRESTADO);

            repository.save(db);

            return db;
        } else {
            throw new RuntimeException("Não foi possivel atualizar o Status");
        }

    }
}
