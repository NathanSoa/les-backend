package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import java.util.List;

@Data
public class Address {
    private Long id;
    private String alias;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private List<AddressPurposeItem> streetPurpose;

    private Address() { }

    public static Address Create() {
        return new Address();
    }

    public Address withId(Long id) {
        this.id = id;
        return this;
    }

    public Address withAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public Address withStreet(String street) {
        this.street = street;
        return this;
    }

    public Address withNumber(String number) {
        this.number = number;
        return this;
    }

    public Address withComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public Address withNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    public Address withState(String state) {
        this.state = state;
        return this;
    }

    public Address withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Address withStreetPurpose(List<AddressPurposeItem> streetPurpose) {
        this.streetPurpose = streetPurpose;
        return this;
    }
}
