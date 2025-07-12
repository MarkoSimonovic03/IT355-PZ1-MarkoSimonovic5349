package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model;

import java.util.Date;

public class Loan {
    private Book book;
    private User user;
    private Date loanDate;

    public Loan() {
    }

    public Loan(Book book, User user, Date loanDate) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", user=" + user +
                ", loanDate=" + loanDate +
                '}';
    }
}
