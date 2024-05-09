package com.sebas.springboot.di.app.springbootdi.controllers;

import com.sebas.springboot.di.app.springbootdi.models.Product;
import com.sebas.springboot.di.app.springbootdi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping(value = "/{productId}")
    public Product show(@PathVariable Long productId) {
        return productService.findById(productId);
    }

}
