package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.controller;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.LoanForm;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.SessionUser;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
public class LoanController {
    private final LoanService loanService;
    private final SessionUser sessionUser;

    public LoanController(LoanService loanService, SessionUser sessionUser) {
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
    public String loanBook(@ModelAttribute LoanForm form) {
        if (!sessionUser.isLogged()) return "redirect:/login";
        boolean success = loanService.createLoan(form.getName(), form.getUsername());
        if (!success) return "redirect:/login";

        return "redirect:/loans";
    }

    @PostMapping("finishLoan")
    public String finishLoan(@ModelAttribute LoanForm form) {
        if (!sessionUser.isLogged()) return "redirect:/login";
        boolean success = loanService.finishLoan(form.getName(), form.getUsername());
        if (!success) return "redirect:/login";

        return "redirect:/loans";
    }

    @PostMapping("deleteLoan")
    public String deleteLoan(@ModelAttribute LoanForm form,
                             @RequestParam LocalDate loanDate,
                             @RequestParam LocalDate returnDate
                             ) {
        if (!sessionUser.isLogged()) return "redirect:/login";
        boolean success = loanService.deleteLoan(form.getName(), form.getUsername(), loanDate, returnDate);
        if (!success) return "redirect:/login";

        return "redirect:/loans";
    }
}
