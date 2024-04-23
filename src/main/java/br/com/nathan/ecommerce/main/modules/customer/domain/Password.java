package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class Password {

    private String value;

    private Password(String password) {
        this.value = password;
    }

    public static Password Create(String password) {
        return new Password(password);
    }
}
