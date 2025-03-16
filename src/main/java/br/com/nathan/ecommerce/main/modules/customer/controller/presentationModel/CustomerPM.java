package br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel;

import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;

import java.util.List;

public record CustomerPM(Long id,
                         String name,
                         String cpf,
                         String email,
                         String phone,
                         List<Address> addresses,
                         List<Card> cards,
                         Boolean active) {
}
