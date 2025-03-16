package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.AddAddressDTO;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurposeItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AddAddressDTOToAddress implements Mapper<AddAddressDTO, Address> {

    @Override
    public Address map(AddAddressDTO raw) {
        var purposeList = new ArrayList<>(
                raw.streetPurpose().stream().map((value) -> AddressPurposeItem.Create().withPurpose(value)).toList()
        );

        return Address.Create()
                .withAlias(raw.alias())
                .withStreet(raw.street())
                .withNumber(raw.number())
                .withComplement(raw.complement())
                .withNeighborhood(raw.neighborhood())
                .withCity(raw.city())
                .withState(raw.state())
                .withZipCode(raw.zipCode())
                .withStreetPurpose(purposeList);
    }
}
