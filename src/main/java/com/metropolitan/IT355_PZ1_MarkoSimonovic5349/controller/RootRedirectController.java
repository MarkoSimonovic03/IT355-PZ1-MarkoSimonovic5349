package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootRedirectController {
    @GetMapping("/")
    public String redirectToBooks() {
        return "redirect:/books";
    }
}