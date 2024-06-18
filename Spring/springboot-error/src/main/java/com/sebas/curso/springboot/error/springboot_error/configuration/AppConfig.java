package com.sebas.curso.springboot.error.springboot_error.configuration;

import com.sebas.curso.springboot.error.springboot_error.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "Name1", "LastName1");
        User user2 = new User(2L, "Name2", "LastName2");
        User user3 = new User(3L, "Name3", "LastName3");
        User user4 = new User(4L, "Name4", "LastName4");
        User user5 = new User(5L, "Name5", "LastName5");
        User user6 = new User(6L, "Name6", "LastName6");

        users.addAll(
                Arrays.asList(
                        user1,
                        user2,
                        user3,
                        user4,
                        user5,
                        user6
                ));

        return users;
    }

}
