package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class Phone {

    private String value;

    private Phone(String phone) {
        this.value = phone;
    }

    public static Phone Create(String phone) {
        return new Phone(phone);
    }
}
