package com.example.challenge.libary.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

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
    private Date dateReserve;
    private Date dateReturn;
    private Double value;

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

    public Date getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(Date dateReserve) {
        this.dateReserve = dateReserve;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public Double getValue() {
        return value;
    }

    public double totalValue(Date dateReserve, Date dateReturn) {
        value = 5.0;
        Double interestPerDay;
        Double fine;

        Calendar calReserve = Calendar.getInstance();
        Calendar calReturn = Calendar.getInstance();

        calReserve.setTime(dateReserve);
        calReturn.setTime(dateReturn);

        int dayReserve = calReserve.get(Calendar.DATE);
        int dayReturn = calReturn.get(Calendar.DATE);
        int qtDays = dayReturn - dayReserve;

        if(qtDays > 3) {
            interestPerDay = 5 + qtDays * 0.004;
            fine = interestPerDay * 0.05;
            value += fine;
        }
        else if (qtDays > 5) {
            interestPerDay = 5 + qtDays * 0.006;
            fine = interestPerDay * 0.07;
            value += fine;
        }
        else {
            value = 0.0;
        }

        return value;
    }
}
