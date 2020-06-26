package com.example.challenge.libary.models;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
    @ManyToOne
    private Client client;

    public Book() {

    }

    public Book(String title, Client client) {
        this.title = title;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

}
