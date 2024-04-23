package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressToAddressEntity implements Mapper<Address, AddressEntity> {

    @Override
    public AddressEntity map(Address raw) {
        var address = new AddressEntity()
                .withAlias(raw.getAlias())
                .withCity(raw.getCity())
                .withComplement(raw.getComplement())
                .withNeighborhood(raw.getNeighborhood())
                .withNumber(raw.getNumber())
                .withState(raw.getState())
                .withStreet(raw.getStreet())
                .withZipCode(raw.getZipCode())
                .withStreetPurpose(transformStreetPurpose(raw.getStreetPurpose()));
        address.setActive(true);
        return address;
    }

    private String transformStreetPurpose(List<String> streetPurpose) {
        return String.join(" - ", streetPurpose);
    }
}
