package com.example.gokfitness;

import java.util.UUID;

public class User {
    private String id;
    private String username;
    private String password;

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(UUID id, String username, String password) {
        this.id = String.valueOf(id);
        this.username = username;
        this.password = password;
    }
}
