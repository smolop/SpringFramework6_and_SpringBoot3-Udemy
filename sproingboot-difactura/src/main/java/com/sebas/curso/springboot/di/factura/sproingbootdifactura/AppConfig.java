package com.sebas.curso.springboot.di.factura.sproingbootdifactura;

import com.sebas.curso.springboot.di.factura.sproingbootdifactura.models.Item;
import com.sebas.curso.springboot.di.factura.sproingbootdifactura.models.Product;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
})
public class AppConfig {

    @Bean("default")
    public List<Item> invoiceItems() {
        Product p1 = new Product("Sony Camera", "800");
        Product p2 = new Product("Bianchi Cycle", "1200");

        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }

    @Bean
    public List<Item> officeInvoiceItems() {
        Product p1 = new Product("Asus Monitor", "700");
        Product p2 = new Product("Racer Notebook", "2400");
        Product p3 = new Product("HP Printer", "800");
        Product p4 = new Product("Office Desk", "900");

        return Arrays.asList(
                new Item(p1, 2),
                new Item(p2, 6),
                new Item(p3, 1),
                new Item(p4, 4));
    }

}
