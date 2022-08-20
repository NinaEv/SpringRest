package com.example.rest.service;

import com.example.rest.authorities.Authorities;
import com.example.rest.exception.UnauthorizedUser;
import com.example.rest.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.rest.model.User;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> list = repository.getUserAuthorities(user);
        if (isEmpty(list)) throw new UnauthorizedUser("Unknown user " + user);
        return list;
    }

    private boolean isEmpty(List<Authorities> list) {
        return list == null || list.isEmpty();
    }
}

