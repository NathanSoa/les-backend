package br.com.nathan.ecommerce.main.modules.coupon.controller.presentationModel;

public record CouponPM (
        Long id,
        String code,
        Double discount
) {
}
