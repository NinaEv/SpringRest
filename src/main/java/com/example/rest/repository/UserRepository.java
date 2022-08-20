package com.example.rest.repository;

import com.example.rest.authorities.Authorities;
import com.example.rest.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<User, List<Authorities>> map = new ConcurrentHashMap<>();

    public UserRepository() {
        addUserAuthorities(new User("nina", "rest"), Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }


    public List<Authorities> getUserAuthorities(User user) {
        return map.get(user);
    }

    public void addUserAuthorities(User user, List<Authorities> list) {
        map.put(user, list);
    }
}