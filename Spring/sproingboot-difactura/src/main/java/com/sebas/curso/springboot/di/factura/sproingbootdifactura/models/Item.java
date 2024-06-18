package com.sebas.curso.springboot.di.factura.sproingbootdifactura.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Product product;
    private Integer quantity;

    public double getSummary(){
        return Integer.parseInt(product.getPrice()) * getQuantity();
    }

}
