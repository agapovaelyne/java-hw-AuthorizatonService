package com.example.authorize.repository;

import com.example.authorize.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map fullPermUsers = new HashMap();

    public UserRepository() {
        fullPermUsers.put("Elyne", "qwerty");
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (fullPermUsers.containsKey(user) && fullPermUsers.get(user).equals(password)) {
            return List.of(Authorities.values());
        }
        return new ArrayList<>();
    }
}
