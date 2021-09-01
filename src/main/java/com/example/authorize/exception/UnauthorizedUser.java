package com.example.authorize.exception;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
