package br.com.nathan.ecommerce.main.modules.customer.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressPurposeEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.AddressPurposeRepository;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.AddressRepository;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.CardRepository;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class CustomerDAO implements IDAO<CustomerEntity> {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CardRepository cardRepository;
    private final AddressPurposeRepository addressPurposeRepository;

    @Override
    @Transactional
    public CustomerEntity save(CustomerEntity entity) {
        for (AddressEntity address : entity.getAddressEntity()) {
            List<AddressPurposeEntity> savedPurposes = new ArrayList<>(addressPurposeRepository.saveAll(address.getAddressPurposes()));
            address.setAddressPurposes(savedPurposes);
        }
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
