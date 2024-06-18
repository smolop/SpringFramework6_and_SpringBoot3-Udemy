package com.sebas.curso.springboot.di.factura.sproingbootdifactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Getter
@Setter
@Component
@RequestScope
@JsonIgnoreProperties({"advisors", "targetSource", "beanFactory", "beanExpressionResolver"})
public class Invoice {

    @Autowired
    private Client client;
    @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    public Invoice() {
        System.out.println("Creando el componente de la factura");
        System.out.println(client);
        System.out.println(description);
    }

    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Pepito"));
        System.out.println(client.toString());
        description = description.concat(" del client: ".concat(client.getName()).concat(" " ).concat(client.getLastname()));
        System.out.println(description);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente o bean invoice");
    }

    public double getTotal(){
        return items
                .stream()
                .map(Item::getSummary)
                .reduce(Double::sum)
                .orElse(0.0);
    }

}
