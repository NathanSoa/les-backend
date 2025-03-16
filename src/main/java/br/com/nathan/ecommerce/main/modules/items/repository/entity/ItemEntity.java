package br.com.nathan.ecommerce.main.modules.items.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.modules.items.domain.Status;
import br.com.nathan.ecommerce.main.modules.product.repository.entity.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "product_items")
@Data
@EqualsAndHashCode(callSuper = true)
public class ItemEntity extends BaseEntity {

    @NotNull
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private ProductEntity product;

    public ItemEntity withCode(String code) {
        this.code = code;
        return this;
    }

    public ItemEntity withStatus(Status status) {
        this.status = status;
        return this;
    }

    public ItemEntity withProduct(ProductEntity product) {
        this.product = product;
        return this;
    }
}
