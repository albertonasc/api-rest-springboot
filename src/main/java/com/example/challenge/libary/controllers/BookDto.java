package com.example.challenge.libary.controllers;

import com.example.challenge.libary.models.Book;
import com.example.challenge.libary.models.BookStatus;
import com.example.challenge.libary.models.Client;

import java.util.Date;

public class BookDto {

    private Long id;
    private String title;
    private BookStatus status;
    private Client client;
    private Date dateReserve;
    private Date dateReturn;
    private Double value;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.status = book.getStatus();
        this.client = book.getClient();
        this.dateReserve = book.getDateReserve();
        this.dateReturn = book.getDateReturn();
        this.value = book.getValue();
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
