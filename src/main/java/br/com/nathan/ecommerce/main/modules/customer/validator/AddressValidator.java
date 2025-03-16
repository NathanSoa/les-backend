package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.exceptions.MessageResolver;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurpose;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AddressValidator implements Validator<Address> {

    private final MessageResolver messageResolver;
    private List<String> codes;

    public AddressValidator(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    @Override
    public Map<String, List<String>> validate(Address object) {
        codes = new ArrayList<>();
        validateAlias(object.getAlias());
        validateStreet(object.getStreet());
        validateNumber(object.getNumber());
        validateNeighborhood(object.getNeighborhood());
        validateCity(object.getCity());
        validateState(object.getState());
        validateZipCode(object.getZipCode());
        return Map.of("addresses", messageResolver.resolve(codes));
    }

    public void validateAlias(String alias) {
        if (alias == null || alias.isEmpty()) {
            codes.add("address.alias");
        }
    }

    public void validateStreet(String street) {
        if (street == null || street.isEmpty()) {
            codes.add("address.street");
        }
    }

    public void validateNumber(String number) {
        if (number == null || number.isEmpty()) {
            codes.add("address.number");
        }
    }

    public void validateNeighborhood(String neighborhood) {
        if (neighborhood == null || neighborhood.isEmpty()) {
            codes.add("address.neighborhood");
        }
    }

    public void validateCity(String city) {
        if (city == null || city.isEmpty()) {
            codes.add("address.city");
        }
    }

    public void validateState(String state) {
        if (state == null || state.isEmpty()) {
            codes.add("address.state");
        }
    }

    public void validateZipCode(String zipCode) {
        if (zipCode == null || zipCode.isEmpty()) {
            codes.add("address.zipcode.required");
        }
        if (zipCode != null && !zipCode.matches("\\d{5}-\\d{3}")) {
            codes.add("address.zipcode.format");
        }
    }

    public void validateStreetPurpose(List<String> streetPurpose) {
        streetPurpose.forEach(each -> {
            if (each == null || each.isEmpty()) {
                codes.add("address.streetPurpose.required");
            }

            if((each != null && each.isEmpty()) &&
                    !each.equals(AddressPurpose.BILLING.getDescription()) &&
                    !each.equals(AddressPurpose.SHIPPING.getDescription())
            ) {
                codes.add("address.streetPurpose.invalid");
            }
        });
    }
}
