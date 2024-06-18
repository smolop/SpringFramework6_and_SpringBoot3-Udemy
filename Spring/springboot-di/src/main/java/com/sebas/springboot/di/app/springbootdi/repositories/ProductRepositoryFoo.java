package com.sebas.springboot.di.app.springbootdi.repositories;

import com.sebas.springboot.di.app.springbootdi.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {


    @Override
    public List<Product> findAll() {
        return Collections.singletonList(
                new Product(1L, "Asus 27 Monitor", 600L)
        );
    }

    @Override
    public Product findById(Long productId) {
        return new Product(productId, "Asus 27 Monitor", 600L);
    }
}
