package br.com.nathan.ecommerce.main.modules.customer.controller.dto;

import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;

import java.util.List;

public record CustomerDTO(String name,
                          String email,
                          String password,
                          String cpf,
                          String phone,
                          List<Address> addresses,
                          List<Card> cards,
                          Boolean active) {
}
