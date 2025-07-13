package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.User;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.repository.MemoryBase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final MemoryBase db;

    public UserService(MemoryBase db) {
        this.db = db;
    }

    public boolean exist(String username){
        return db.getUserList().stream().anyMatch(u -> u.getUsername().equals(username));
    }

    public void register(User user){
        db.getUserList().add(user);
    }

    public Optional<User> login(String username, String password){
        return db.getUserList().stream().filter(u -> (u.getUsername().equals(username) && u.getPassword().equals(password))).findFirst();
    }

    public Optional<User> returnByUsername(String username){
        return db.getUserList().stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }
}
