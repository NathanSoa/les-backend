package br.com.nathan.ecommerce.main.modules.cardFlag.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "card_flags")
@EqualsAndHashCode(callSuper = true)
public class FlagEntity extends BaseEntity {

    @NotBlank
    private String name;

    public FlagEntity withName(String name) {
        this.name = name;
        return this;
    }
}
