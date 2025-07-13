package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionUser {
    private String username;

    public boolean isLogged(){
        return username != null;
    }

    public void logout(){
        username = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
