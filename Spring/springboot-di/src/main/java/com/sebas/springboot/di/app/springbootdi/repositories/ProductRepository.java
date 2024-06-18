package com.sebas.springboot.di.app.springbootdi.repositories;

import com.sebas.springboot.di.app.springbootdi.models.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> findAll();

    public Product findById(Long productId);

}
