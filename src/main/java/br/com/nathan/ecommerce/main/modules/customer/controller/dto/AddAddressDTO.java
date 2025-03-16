package br.com.nathan.ecommerce.main.modules.customer.controller.dto;

import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurpose;

import java.util.List;

public record AddAddressDTO(
        String alias,
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String zipCode,
        List<AddressPurpose> streetPurpose
){ }
