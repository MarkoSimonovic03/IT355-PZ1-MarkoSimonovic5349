package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.controller;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.LoanForm;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.SessionUser;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.BookService;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.LoanService;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoanController {
    private final BookService bookService;
    private final UserService userService;
    private final LoanService loanService;
    private final SessionUser sessionUser;

    public LoanController(BookService bookService, UserService userService, LoanService loanService, SessionUser sessionUser) {
        this.bookService = bookService;
        this.userService = userService;
        this.loanService = loanService;
        this.sessionUser = sessionUser;
    }

    @GetMapping("/loans")
    public String showLoans(Model model) {
        if (!sessionUser.isLogged()) return "redirect:/login";
        model.addAttribute("loans", loanService.getLoansByUsername(sessionUser.getUsername()));
        model.addAttribute("sessionUser", sessionUser);

        return "loans";
    }

    @PostMapping("/createLoan")
    public String loanBook(@ModelAttribute LoanForm form, Model model) {
        if (!sessionUser.isLogged()) return "redirect:/login";
        boolean success = loanService.createLoan(form.getName(), form.getUsername());
        if(!success) return "redirect:/login";

        return "redirect:/loans";
    }

    @PostMapping("finishLoan")
    public String returnBook(@ModelAttribute LoanForm form, Model model) {
        if (!sessionUser.isLogged()) return "redirect:/login";
        boolean success = loanService.finishLoan(form.getName(), form.getUsername());
        if(!success) return "redirect:/login";

        return "redirect:/loans";
    }
}
