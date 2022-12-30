package com.example.gokfitness;

import java.util.UUID;

public class UserUpdate extends User{
    private String sex;

    public UserUpdate(String sex) {
        this.sex = sex;
    }

    public UserUpdate(UUID id, String username, String password, String sex) {
        super(id, username, password);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
