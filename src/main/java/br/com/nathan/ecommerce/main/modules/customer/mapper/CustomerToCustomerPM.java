package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel.CustomerPM;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerPM implements Mapper<Customer, CustomerPM> {

    @Override
    public CustomerPM map(Customer raw) {
        return new CustomerPM(
                raw.getId(),
                raw.getName().getValue(),
                raw.getCpf().getValue(),
                raw.getEmail().getValue(),
                raw.getPhone().getValue(),
                raw.getAddress(),
                raw.getCard(),
                raw.getActive()
        );
    }
}
