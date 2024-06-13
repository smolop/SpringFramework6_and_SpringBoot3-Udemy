package com.sebas.curso.springboot.error.springboot_error.controllers;

import com.sebas.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.sebas.curso.springboot.error.springboot_error.models.User;
import com.sebas.curso.springboot.error.springboot_error.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index() {
//        int value = 100 / 0;
        int value = Integer.parseInt("10X");
        log.info(String.valueOf(value));
        return "200 OK";
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<User> showUser(@PathVariable(name = "id") String id) {
        User user = userService
                .findById(Long.parseLong(id))
                .orElseThrow(() -> new UserNotFoundException("User or role not found error"));
//        if (optionalUser.isEmpty())
//            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

}
