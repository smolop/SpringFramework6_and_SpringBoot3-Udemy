package com.sebas.curso.springboot.calendar.interceptor.springboot_calendar_interceptor.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request) {

        Map<String, Object> data = new HashMap<>();
        data.put("title", "Welcome to the customer service");
        data.put("time", LocalDateTime.now().toString());
        Object message = request.getAttribute("message");
        data.put("message", message);
        return ResponseEntity.ok(data);
    }

}
