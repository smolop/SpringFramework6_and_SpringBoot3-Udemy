package com.sebas.springboot.di.app.springbootdi;

import com.sebas.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.sebas.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources(
        @PropertySource("classpath:values.properties")
)
public class AppConfig {

    @Bean
    @Primary
    public ProductRepository productRepository(){
        return new ProductRepositoryJson();
    }

}
