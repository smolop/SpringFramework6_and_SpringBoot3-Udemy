package com.sebas.springboot.di.app.springbootdi.repositories;

import com.sebas.springboot.di.app.springbootdi.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;



// @RequestScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Corsair 32GB Memory", 300L),
                new Product(2L, "Intel Core i9 CPU", 850L),
                new Product(3L, "Razer Mini 60% Keyboard", 180L),
                new Product(4L, "Gigabyte Motherboard", 490L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long productId) {
        Optional<Product> productOpt = data.stream()
                .filter(innerProduct -> productId.equals(innerProduct.getId()))
                .findFirst();
        return productOpt.orElse(null);
    }

}
