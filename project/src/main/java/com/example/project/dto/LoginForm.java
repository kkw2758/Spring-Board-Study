package com.example.project.dto;

public class LoginForm {
    public String id;
    public String password;

    public LoginForm(String id, String password) {
        this.id = id;
        this.password = password;
    }
    @Override
    public String toString(){
        return id + ' ' +password;
    };
}
