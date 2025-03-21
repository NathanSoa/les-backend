package br.com.nathan.ecommerce.main.modules.customer.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@EqualsAndHashCode(callSuper = true)
public class AddressEntity extends BaseEntity {

    @NotBlank
    private String alias;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private String complement;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zipCode;

    @OneToMany
    @JoinColumn(name = "address_id")
    private List<AddressPurposeEntity> addressPurposes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    public AddressEntity withAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public AddressEntity withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressEntity withNumber(String number) {
        this.number = number;
        return this;
    }

    public AddressEntity withComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public AddressEntity withNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public AddressEntity withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressEntity withState(String state) {
        this.state = state;
        return this;
    }

    public AddressEntity withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressEntity withAddressPurposes(List<AddressPurposeEntity> streetPurposes) {
        this.addressPurposes = streetPurposes;
        return this;
    }

    public AddressEntity withId(Long id) {
        super.setId(id);
        return this;
    }
}
