package br.com.nathan.ecommerce.main.modules.coupon.domain;

import lombok.Data;

@Data
public class Coupon {
    private Long id;
    private String code;
    private Double discount;

    private Coupon() { }

    public static Coupon Create() {
        return new Coupon();
    }

    public Coupon withCode(String code) {
        this.code = code;
        return this;
    }

    public Coupon withDiscount(Double discount) {
        this.discount = discount;
        return this;
    }

    public Coupon withId(Long id) {
        this.id = id;
        return this;
    }
}
