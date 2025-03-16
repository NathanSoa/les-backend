package br.com.nathan.ecommerce.main.modules.customer.controller.dto;

import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurpose;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;

import java.util.List;

public record CustomerDTO(String name,
                          String email,
                          String password,
                          String confirmPassword,
                          String cpf,
                          String phone,
                          String birthdate,
                          List<AddressDTO> addresses,
                          List<CardDTO> cards,
                          Boolean active) {

    public record AddressDTO(String alias,
                             String street,
                             String number,
                             String complement,
                             String neighborhood,
                             String city,
                             String state,
                             String zipCode,
                             List<AddressPurpose> streetPurpose) {
    }

    public record CardDTO(
            String flag,
            String name,
            String number,
            String type,
            String securityCode,
            Boolean main
    ) {}
}
