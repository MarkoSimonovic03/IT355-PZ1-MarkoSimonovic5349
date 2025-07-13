package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;

@Component
@RequestScope
public class LoanForm {
    private Book book;
    private Date loanDate;

    public LoanForm() {
    }

    public LoanForm(Book book, Date loanDate) {
        this.book = book;
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    @Override
    public String toString() {
        return "LoanForm{" +
                "book=" + book +
                ", loanDate=" + loanDate +
                '}';
    }
}
