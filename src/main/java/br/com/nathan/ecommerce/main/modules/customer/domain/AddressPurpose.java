package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Getter;

@Getter
public enum AddressPurpose {
    BILLING("Cobrança"),
    DELIVERY("Entrega");

    private final String description;

    AddressPurpose(String description) {
        this.description = description;
    }

}
