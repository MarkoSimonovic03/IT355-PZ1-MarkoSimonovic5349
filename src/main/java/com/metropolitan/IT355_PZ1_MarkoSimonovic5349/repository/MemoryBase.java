package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.repository;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationScope
public class MemoryBase {
    private final List<User> userList = new ArrayList<>();
    private final List<Book> bookList = new ArrayList<>();
    private final List<Author> authorList = new ArrayList<>();
    private final List<Category> categoryList = new ArrayList<>();
    private final List<Loan> loanList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }
}
