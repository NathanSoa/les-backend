package br.com.nathan.ecommerce.main.modules.coupon.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.modules.coupon.controller.presentationModel.CouponPM;
import br.com.nathan.ecommerce.main.modules.coupon.mapper.CouponToCouponPM;
import br.com.nathan.ecommerce.main.modules.coupon.useCases.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@BaseController("/coupons")
@RequiredArgsConstructor
public class CouponController {
    private final CouponService service;
    private final CouponToCouponPM mapper;

    @GetMapping("/{code}")
    public ResponseEntity<CouponPM> findByCode(@PathVariable String code) {
        return ResponseEntity.ok(
                this.mapper.map(this.service.findByCode(code))
        );
    }
}
