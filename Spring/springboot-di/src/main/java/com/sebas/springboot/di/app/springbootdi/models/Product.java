package com.sebas.springboot.di.app.springbootdi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Cloneable {

    private Long id;
    private String name;
    private Long price;
    private String currency = String.valueOf(CURRENCY.EUR);

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private enum CURRENCY {
        EUR,
        USD
    }

    @Override
    public Product clone() {
        try {
            Product clone = (Product) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return new Product(id, name, price, currency);
        }
    }

}
