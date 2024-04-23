package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class Name {

    private String value;

    private Name(String name) {
        this.value = name;
    }

    public static Name Create(String name) {
        return new Name(name);
    }
}
