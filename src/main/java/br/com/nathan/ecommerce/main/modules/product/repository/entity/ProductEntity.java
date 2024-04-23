package br.com.nathan.ecommerce.main.modules.product.repository.entity;

import br.com.nathan.ecommerce.main.config.constants.ValidationConstants;
import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends BaseEntity {

    @NotBlank(message = "{customer.name.not-blank}")
    @Size(min = ValidationConstants.NAME_MIN_LENGTH, max = ValidationConstants.NAME_MAX_LENGTH, message = "{customer.name.size}")
    private String name;

    @NotNull
    private Double price;


    @NotBlank(message = "{customer.name.not-blank}")
    @Size(min = ValidationConstants.NAME_MIN_LENGTH, max = ValidationConstants.NAME_MAX_LENGTH, message = "{customer.name.size}")
    private String slug;

    public ProductEntity withName(String name) {
        this.name = name;
        return this;
    }

    public ProductEntity withPrice(Double price) {
        this.price = price;
        return this;
    }

    public ProductEntity withId(Long id) {
        this.setId(id);
        return this;
    }

    public ProductEntity withActive(boolean active) {
        this.setActive(active);
        return this;
    }

    public ProductEntity withSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
