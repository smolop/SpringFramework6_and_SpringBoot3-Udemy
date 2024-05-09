package com.sebas.springboot.di.app.springbootdi.services;

import com.sebas.springboot.di.app.springbootdi.models.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findById(Long productId);

}
