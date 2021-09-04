package com.example.authorize.model;

import javax.validation.constraints.*;

public class User {

    @NotBlank
    @Size(min = 2, max = 15)
    private String name;

    @NotBlank
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-ZА-Я]).{8,}$")
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(String age) {
        this.password = age;
    }
}
