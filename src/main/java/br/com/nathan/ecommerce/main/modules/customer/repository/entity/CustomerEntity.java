package br.com.nathan.ecommerce.main.modules.customer.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.config.constants.ValidationConstants;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends BaseEntity {

    @NotBlank(message = "{customer.name.not-blank}")
    @Size(min = ValidationConstants.NAME_MIN_LENGTH, max = ValidationConstants.NAME_MAX_LENGTH, message = "{customer.name.size}")
    private String name;

    @Email
    @NotBlank
    private String email;

    @CPF
    @NotBlank
    private String cpf;

    @NotBlank
    @Pattern(regexp = "(\\(\\d{2}\\)\\s)(\\d{4,5}\\-\\d{4})", message = "Phone must be in the format (99) 99999-9999")
    private String phone;

    @NotBlank
    private String password;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<AddressEntity> addressEntity = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<CardEntity> cardEntity = new ArrayList<>();

    public CustomerEntity withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerEntity withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerEntity withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public CustomerEntity withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerEntity withPassword(String password) {
        this.password = password;
        return this;
    }

    public CustomerEntity withId(Long id) {
        this.setId(id);
        return this;
    }

    public CustomerEntity withActive(Boolean active) {
        this.setActive(active);
        return this;
    }

    public CustomerEntity withAddress(List<AddressEntity> addressEntity) {
        if(addressEntity == null || addressEntity.isEmpty()) throw new IllegalArgumentException("address.required");
        this.addressEntity = addressEntity;
        return this;
    }

    public CustomerEntity withCard(List<CardEntity> cardEntity) {
        if(cardEntity == null || cardEntity.isEmpty()) throw new IllegalArgumentException("card.required");
        this.cardEntity = cardEntity;
        return this;
    }
}
