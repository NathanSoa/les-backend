package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class AddressPurposeItem {

    private Long id;
    private AddressPurpose purpose;


    private AddressPurposeItem() { }

    public static AddressPurposeItem Create() {
        return new AddressPurposeItem();
    }

    public AddressPurposeItem withId(Long id) {
        this.id = id;
        return this;
    }

    public AddressPurposeItem withPurpose(AddressPurpose purpose) {
        this.purpose = purpose;
        return this;
    }
}
