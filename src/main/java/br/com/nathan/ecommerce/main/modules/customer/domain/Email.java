package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class Email {

    private String value;

    private Email(String email) {
        this.value = email;
    }

    public static Email Create(String email) {
        return new Email(email);
    }
}
