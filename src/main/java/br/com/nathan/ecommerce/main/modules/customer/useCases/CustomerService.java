package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.domain.AbstractService;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.core.interfaces.PasswordUtils;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.customer.business.CustomerBusinessRules;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.AddAddressDTO;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.domain.Password;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.AddressRepository;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

import static br.com.nathan.ecommerce.main.core.utils.Utils.Hash256;


@Service
public class CustomerService extends AbstractService<Customer, CustomerEntity> {
    private final Mapper<AddAddressDTO, Address> addAddressDTOAddressMapper;
    private final CustomerBusinessRules businessRules;


    @Autowired
    public CustomerService(
        IDAO<CustomerEntity> dao,
        Mapper<Customer, CustomerEntity> mapperToEntity,
        Mapper<CustomerEntity, Customer> mapperToDomain,
        CustomerBusinessRules businessRules,
        Validator<Customer> validator,
        Mapper<AddAddressDTO, Address> addAddressDTOAddressMapper
    ) {
        super(dao, mapperToEntity, mapperToDomain, validator);
        this.businessRules = businessRules;
        this.addAddressDTOAddressMapper = addAddressDTOAddressMapper;
    }

    @Override
    public Customer create(Customer customer) {
        businessRules.validate(customer);
        throwErrorIfInvalid(customer);

        final var password = Password.Create(Hash256(customer.getPassword().getValue()));
        customer.setPassword(password);

        final var entity = dao.save(mapperToEntity.map(customer));
        return mapperToDomain.map(entity);
    }

    @Override
    public Customer update(Customer customer, Long id) {
        businessRules.validate(customer);
        var dbCustomer = findById(id);
        customer.setPassword(dbCustomer.getPassword());
        return super.update(customer, id);
    }

    @Transactional
    public void updatePassword(Long id, String password) {
        final var customer = findById(id);
        final var newPassword = Password.Create(Hash256(password));
        customer.setPassword(newPassword);
        this.update(customer, id);
    }

    @Transactional
    public void addAddress(AddAddressDTO addressDTO) {
        final var customer = findById(1L);
        Address newAddress = this.addAddressDTOAddressMapper.map(addressDTO);

        Optional<Address> existingAddress = customer.getAddress().stream()
                .filter(addr -> addr.getId().equals(newAddress.getId()))
                .findFirst();

        if (existingAddress.isPresent()) {
            int index = customer.getAddress().indexOf(existingAddress.get());
            Address addressToUpdate = customer.getAddress().get(index);
            addressToUpdate.setStreetPurpose(newAddress.getStreetPurpose());
            customer.getAddress().set(index, addressToUpdate);
        } else {
            customer.getAddress().add(newAddress);
        }
        this.update(customer, customer.getId());
    }
}
