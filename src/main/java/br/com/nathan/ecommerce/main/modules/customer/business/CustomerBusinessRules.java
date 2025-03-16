package br.com.nathan.ecommerce.main.modules.customer.business;

import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerBusinessRules {

    private final ValidateCardFlag validateCardFlag;
    private final ValidateBillingAddress validateBillingAddress;
    private final ValidateShippingAddress validateDeliveryAddress;

    public void validate(Customer object) {
        validateCardFlag.process(object.getCard());
        validateBillingAddress.process(object.getAddress());
        validateDeliveryAddress.process(object.getAddress());
    }
}
