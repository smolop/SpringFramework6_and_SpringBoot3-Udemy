package com.sebas.springboot.di.app.springbootdi.services;

import com.sebas.springboot.di.app.springbootdi.models.Product;
import com.sebas.springboot.di.app.springbootdi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Value("${prop.taxPercentage}")
    private double taxPercentage;

    public List<Product> findAll(){
        return productRepository.findAll()
                .stream()
                .map( innerProduct -> {
                    Double pricesWithTaxes = innerProduct.getPrice() * taxPercentage;
                    Product clonedProduct = innerProduct.clone();
                    clonedProduct.setPrice(pricesWithTaxes.longValue());
                    return clonedProduct;
                    /*innerProduct.setPrice(pricesWithTaxes.longValue());
                    return innerProduct;*/
                })
                .toList();
    }

    public Product findById(Long productId) {
        return productRepository.findById(productId);
    }


}
