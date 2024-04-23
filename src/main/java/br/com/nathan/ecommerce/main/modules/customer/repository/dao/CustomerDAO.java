package br.com.nathan.ecommerce.main.modules.customer.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.AddressRepository;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.CardRepository;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class CustomerDAO implements IDAO<CustomerEntity> {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CardRepository cardRepository;

    @Override
    @Transactional
    public CustomerEntity save(CustomerEntity entity) {
        addressRepository.saveAll(entity.getAddressEntity());
        cardRepository.saveAll(entity.getCardEntity());
        return customerRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.findById(id);
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("customer.not-found"));
    }

    @Override
    @Transactional
    public Set<CustomerEntity> findAll() {
        return new HashSet<>(customerRepository.findAll());
    }
}
