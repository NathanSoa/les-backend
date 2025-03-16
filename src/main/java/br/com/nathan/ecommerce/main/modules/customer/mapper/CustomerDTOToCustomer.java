package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.CustomerDTO;
import br.com.nathan.ecommerce.main.modules.customer.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDTOToCustomer implements Mapper<CustomerDTO, Customer> {

    @Override
    public Customer map(CustomerDTO raw) {
        return Customer.Create()
                .withName(raw.name())
                .withEmail(raw.email())
                .withPassword(raw.password())
                .withCPF(raw.cpf())
                .withPhone(raw.phone())
                .withActive(raw.active())
                .withPassword(raw.password())
                .withAddress(mapAddresses(raw.addresses()))
                .withCard(mapCards(raw.cards()));
    }

    public List<Address> mapAddresses(List<CustomerDTO.AddressDTO> dtos) {
        return dtos.stream().map(dto -> Address.Create()
                    .withCity(dto.city())
                    .withComplement(dto.complement())
                    .withNeighborhood(dto.neighborhood())
                    .withNumber(dto.number())
                    .withState(dto.state())
                    .withStreet(dto.street())
                    .withZipCode(dto.zipCode())
                    .withStreetPurpose(dto.streetPurpose().stream().map(item -> AddressPurposeItem.Create().withPurpose(item)).toList())
                    .withAlias(dto.alias())
                ).toList();
    }

    public List<Card> mapCards(List<CustomerDTO.CardDTO> dtos) {
        return dtos.stream().map(dto -> Card.Create()
                        .withFlag(dto.flag())
                        .withNumber(dto.number())
                        .withSecurityCode(dto.securityCode())
                        .withMain(dto.main())
                        .withType(dto.type())
                        .withName(dto.name())
                ).toList();
    }
}
