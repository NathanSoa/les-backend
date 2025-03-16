package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurpose;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurposeItem;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressPurposeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressEntityToAddress implements Mapper<AddressEntity, Address> {
    @Override
    public Address map(AddressEntity raw) {
        var addressPurposeList = new ArrayList<>(
                raw.getAddressPurposes().stream()
                        .map(purpose -> AddressPurposeItem.Create()
                                .withId(purpose.getId())
                                .withPurpose(purpose.getPurpose()))
                        .toList()
        );

        return Address.Create()
                    .withId(raw.getId())
                    .withAlias(raw.getAlias())
                    .withCity(raw.getCity())
                    .withComplement(raw.getComplement())
                    .withNeighborhood(raw.getNeighborhood())
                    .withNumber(raw.getNumber())
                    .withState(raw.getState())
                    .withStreet(raw.getStreet())
                    .withZipCode(raw.getZipCode())
                    .withStreetPurpose(addressPurposeList);
    }
}
