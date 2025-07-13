package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoanForm {
    private String bookName;
    private String userUsername;

    public LoanForm() {
    }

    public LoanForm(String bookName, String userUsername) {
        this.bookName = bookName;
        this.userUsername = userUsername;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}
