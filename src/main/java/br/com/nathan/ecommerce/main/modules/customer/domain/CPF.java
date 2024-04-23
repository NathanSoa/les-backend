package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class CPF {

    private final String value;

    private CPF(String cpf) {
        this.value = cpf;
    }

    public static CPF Create(String cpf) {
        return new CPF(cpf);
    }
}

