package com.example.challenge.libary.controllers;

import com.example.challenge.libary.models.Book;
import com.example.challenge.libary.models.BookStatus;
import com.example.challenge.libary.models.Client;

import java.util.List;
import java.util.stream.Collectors;

public class BookDto {

    private Long id;
    private String title;
    private BookStatus status;
    private Client client;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.status = book.getStatus();
        this.client = book.getClient();
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public Client getClient() {
        return client;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
