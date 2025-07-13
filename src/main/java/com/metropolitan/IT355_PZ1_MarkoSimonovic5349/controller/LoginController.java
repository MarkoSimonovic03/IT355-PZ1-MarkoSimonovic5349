package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.controller;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.SessionUser;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.User;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    private final SessionUser sessionUser;
    private final UserService userService;

    public LoginController(SessionUser sessionUser, UserService userService) {
        this.sessionUser = sessionUser;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String forma(Model model) {
        model.addAttribute("error", false);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {


        Optional<User> userOpt = userService.login(username, password);

        if (userOpt.isPresent()) {
            User u = userOpt.get();
            sessionUser.setUsername(u.getUsername());
            return "redirect:/books";
        }

        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        sessionUser.logout();
        return "redirect:/login";
    }
}
