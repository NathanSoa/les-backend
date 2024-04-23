package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.infra.http.AbstractController;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.CustomerDTO;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.CustomerUpdatePasswordDTO;
import br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel.CustomerPM;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.useCases.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static br.com.nathan.ecommerce.main.core.infra.http.HttpHelper.noContent;

@BaseController("/customers")
public class CustomerController extends AbstractController<CustomerDTO, Customer, CustomerPM> {

    private final CustomerService service;

    @Autowired
    public CustomerController(
            CustomerService service,
            Mapper<CustomerDTO, Customer> mapperToDomain,
            Mapper<Customer, CustomerPM> mapperToPm
    ) {
        super(service, mapperToDomain, mapperToPm);
        this.service = service;
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<?> updatePassword(@RequestBody CustomerUpdatePasswordDTO request, @PathVariable Long id) {
        service.updatePassword(id, request.password());
        return noContent();
    }
}
