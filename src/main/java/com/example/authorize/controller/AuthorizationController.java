package com.example.authorize.controller;

import com.example.authorize.exception.InvalidCredentials;
import com.example.authorize.exception.UnauthorizedUser;
import com.example.authorize.model.Authorities;
import com.example.authorize.model.User;
import com.example.authorize.model.UserResolver;
import com.example.authorize.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @PostMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @UserResolver User user) {
        return service.getAuthorities(user);
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
