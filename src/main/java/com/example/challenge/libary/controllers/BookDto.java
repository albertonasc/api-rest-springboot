package com.example.challenge.libary.controllers;

import com.example.challenge.libary.models.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDto {

    private Long id;
    private String title;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public static List<BookDto> convert(List<Book> books) {
        return books.stream().map(BookDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
