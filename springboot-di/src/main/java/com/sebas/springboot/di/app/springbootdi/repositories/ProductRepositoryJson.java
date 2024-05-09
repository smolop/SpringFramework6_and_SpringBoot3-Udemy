package com.sebas.springboot.di.app.springbootdi.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebas.springboot.di.app.springbootdi.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ProductRepositoryJson implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            data = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long productId) {
        return data.stream()
                .filter(innerProduct -> innerProduct.getId().equals(productId))
                .findFirst().orElseThrow();
    }

}
