package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.infra.http.AbstractController;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.AddAddressDTO;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.CustomerDTO;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.CustomerUpdatePasswordDTO;
import br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel.CustomerPM;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.useCases.CustomerService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.nathan.ecommerce.main.core.infra.http.HttpHelper.noContent;
import static br.com.nathan.ecommerce.main.core.infra.http.HttpHelper.ok;

@BaseController("/customers")
public class CustomerController {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService service;
    private final Mapper<CustomerDTO, Customer> mapperToDomain;
    private final Mapper<Customer, CustomerPM> mapperToPm;

    @Autowired
    public CustomerController(
            CustomerService service,
            Mapper<CustomerDTO, Customer> mapperToDomain,
            Mapper<Customer, CustomerPM> mapperToPm
    ) {
        this.service = service;
        this.mapperToDomain = mapperToDomain;
        this.mapperToPm = mapperToPm;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        final var data = mapperToPm.map(service.findById(id));
        return ok(Optional.of(data));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        final var data = service.findAll()
                .stream().map(mapperToPm::map)
                .collect(Collectors.toSet());
        return ok(Optional.of(data));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerDTO request) {
        final var customer = mapperToDomain.map(request);
        service.create(customer);
        return noContent();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return noContent();
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<?> updatePassword(@RequestBody CustomerUpdatePasswordDTO request, @PathVariable Long id) {
        service.updatePassword(id, request.password());
        return noContent();
    }

    @PostMapping("/addresses")
    public ResponseEntity<?> addAddress(@RequestBody AddAddressDTO request) {
        service.addAddress(request);
        return noContent();
    }
}
