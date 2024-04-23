package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressEntityToAddress implements Mapper<AddressEntity, Address> {

    @Override
    public Address map(AddressEntity raw) {
        return Address.Create()
                    .withAlias(raw.getAlias())
                    .withCity(raw.getCity())
                    .withComplement(raw.getComplement())
                    .withNeighborhood(raw.getNeighborhood())
                    .withNumber(raw.getNumber())
                    .withState(raw.getState())
                    .withStreet(raw.getStreet())
                    .withZipCode(raw.getZipCode())
                    .withStreetPurpose(transformStreetPurpose(raw.getStreetPurpose()));
    }

    private List<String> transformStreetPurpose(String streetPurpose) {
        return List.of(streetPurpose.split(" - "));
    }
}
