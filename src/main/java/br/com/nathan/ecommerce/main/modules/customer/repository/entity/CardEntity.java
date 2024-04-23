package br.com.nathan.ecommerce.main.modules.customer.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cards")
@Data
@EqualsAndHashCode(callSuper = true)
public class CardEntity extends BaseEntity {

    @NotBlank
    private String type;

    @NotBlank
    private String number;

    @NotBlank
    private String name;

    @NotBlank
    private String securityCode;

    @NotBlank
    private String flag;

    @NotNull
    private Boolean main;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    public CardEntity withType(String type) {
        this.type = type;
        return this;
    }

    public CardEntity withNumber(String number) {
        this.number = number;
        return this;
    }

    public CardEntity withName(String name) {
        this.name = name;
        return this;
    }

    public CardEntity withSecurityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    public CardEntity withFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public CardEntity withMain(Boolean main) {
        this.main = main;
        return this;
    }
}
