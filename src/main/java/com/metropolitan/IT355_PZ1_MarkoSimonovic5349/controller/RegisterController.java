package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.controller;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.User;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.UserService;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.util.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String prikaziFormu(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("exist", false);
        return "register";
    }

    @PostMapping("/register")
    public String registruj(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        if (AppUtils.isNullOrEmpty(username) || AppUtils.isNullOrEmpty(password)) {
            model.addAttribute("error", true);
            return "register";
        }

        if (userService.exist(username)) {
            model.addAttribute("exist", true);
            return "register";
        }

        userService.register(new User(username,password));
        return "redirect:/login";
    }
}
