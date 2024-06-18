package com.sebas.curso.springboot.error.springboot_error.services;

import com.sebas.curso.springboot.error.springboot_error.models.Role;
import com.sebas.curso.springboot.error.springboot_error.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users
                .stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst();
    }

}
