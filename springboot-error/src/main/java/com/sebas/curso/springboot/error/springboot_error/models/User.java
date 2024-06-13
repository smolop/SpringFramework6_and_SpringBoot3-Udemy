package com.sebas.curso.springboot.error.springboot_error.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String lastName;

    private Role role;

    public User(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.role = new Role();
    }

//    public String getRoleName() {
//        return role.getRoleName();
//    }

}
