package com.sebas.curso.springboot.error.springboot_error.services;

import com.sebas.curso.springboot.error.springboot_error.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

}
