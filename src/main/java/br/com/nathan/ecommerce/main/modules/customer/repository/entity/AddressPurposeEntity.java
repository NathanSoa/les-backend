package br.com.nathan.ecommerce.main.modules.customer.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurpose;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "address_purposes")
@Data
@EqualsAndHashCode(callSuper = true)
public class AddressPurposeEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AddressPurpose purpose;

    public AddressPurposeEntity withPurpose(AddressPurpose purpose) {
        this.purpose = purpose;
        return this;
    }

    public AddressPurposeEntity withId(Long id) {
        super.setId(id);
        return this;
    }

    public AddressPurposeEntity withActive(Boolean active) {
        super.setActive(active);
        return this;
    }
}
