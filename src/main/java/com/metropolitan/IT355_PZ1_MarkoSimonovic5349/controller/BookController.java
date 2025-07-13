package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.controller;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.SessionUser;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.BookService;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.LoanService;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final SessionUser sessionUser;

    public BookController(BookService bookService, SessionUser sessionUser) {
        this.bookService = bookService;
        this.sessionUser = sessionUser;
    }

    @GetMapping
    public String showBooks(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("isLogged", sessionUser.isLogged());
        model.addAttribute("sessionUser", sessionUser);

        return "books";
    }
}
