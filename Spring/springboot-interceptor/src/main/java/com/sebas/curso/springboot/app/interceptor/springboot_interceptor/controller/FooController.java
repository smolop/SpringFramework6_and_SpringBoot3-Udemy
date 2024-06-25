package com.sebas.curso.springboot.app.interceptor.springboot_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("/foo")
    public Map<String, String> foo() {

        return Collections.singletonMap("message", "foo controller handler");
    }

    @GetMapping("/bar")
    public Map<String, String> bar() {

        return Collections.singletonMap("message", "bar controller handler");
    }

    @GetMapping("/baz")
    public Map<String, String> baz() {

        return Collections.singletonMap("message", "baz controller handler");
    }

}
