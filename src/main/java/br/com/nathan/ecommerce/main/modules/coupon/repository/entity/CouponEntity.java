package br.com.nathan.ecommerce.main.modules.coupon.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "coupons")
@Data
@EqualsAndHashCode(callSuper = true)
public class CouponEntity extends BaseEntity {
    @NotNull
    private String code;

    @NotNull
    private Double discount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CouponType type;

    private CouponEntity withCode(String code) {
        this.code = code;
        return this;
    }

    private CouponEntity withDiscount(Double discount) {
        this.discount = discount;
        return this;
    }

    private CouponEntity withType(CouponType type) {
        this.type = type;
        return this;
    }
}
