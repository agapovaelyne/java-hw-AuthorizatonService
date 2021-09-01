package com.example.authorize.controller;

import com.example.authorize.exception.InvalidCredentials;
import com.example.authorize.exception.UnauthorizedUser;
import com.example.authorize.model.Authorities;
import com.example.authorize.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handleRunTimeExc(InvalidCredentials exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + exc.getLocalizedMessage());
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handleRunTimeExc(UnauthorizedUser exc) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error occurred: " + exc.getLocalizedMessage());
    }
}
