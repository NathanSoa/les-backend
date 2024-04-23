package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.domain.AbstractService;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.core.interfaces.PasswordUtils;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.customer.business.CustomerBusinessRules;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.domain.Password;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.nathan.ecommerce.main.core.utils.Utils.Hash256;


@Service
public class CustomerService extends AbstractService<Customer, CustomerEntity> {

    private final CustomerBusinessRules businessRules;

    @Autowired
    public CustomerService(
        IDAO<CustomerEntity> dao,
        Mapper<Customer, CustomerEntity> mapperToEntity,
        Mapper<CustomerEntity, Customer> mapperToDomain,
        CustomerBusinessRules businessRules,
        Validator<Customer> validator
    ) {
        super(dao, mapperToEntity, mapperToDomain, validator);
        this.businessRules = businessRules;
    }

    @Override
    public Customer create(Customer customer) {
        businessRules.validate(customer);
        final var password = Password.Create(Hash256(customer.getPassword().getValue()));
        customer.setPassword(password);
        return super.create(customer);
    }

    @Override
    public Customer update(Customer customer, Long id) {
        businessRules.validate(customer);
        var dbCustomer = findById(id);
        customer.setPassword(dbCustomer.getPassword());
        return super.update(customer, id);
    }

    public void updatePassword(Long id, String password) {
        final var customer = findById(id);
        final var newPassword = Password.Create(Hash256(password));
        customer.setPassword(newPassword);
        this.update(customer, id);
    }
}
