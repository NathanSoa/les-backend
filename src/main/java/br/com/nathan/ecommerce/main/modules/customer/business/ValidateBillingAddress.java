package br.com.nathan.ecommerce.main.modules.customer.business;

import br.com.nathan.ecommerce.main.core.exceptions.BusinessException;
import br.com.nathan.ecommerce.main.core.interfaces.Strategy;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurpose;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurposeItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidateBillingAddress implements Strategy<List<Address>> {

    @Override
    public String process(List<Address> object) {
        object.stream()
                .filter(
                        address -> address.getStreetPurpose().stream()
                        .map(AddressPurposeItem::getPurpose)
                        .toList()
                        .contains(AddressPurpose.BILLING)
                )
                .findFirst()
                .orElseThrow(() -> new BusinessException("address.billing"));
        return null;
    }
}
