package br.com.nathan.ecommerce.main.modules.coupon.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.coupon.controller.presentationModel.CouponPM;
import br.com.nathan.ecommerce.main.modules.coupon.domain.Coupon;
import org.springframework.stereotype.Component;

@Component
public class CouponToCouponPM implements Mapper<Coupon, CouponPM> {
    @Override
    public CouponPM map(Coupon raw) {
        return  new CouponPM(
                raw.getId(),
                raw.getCode(),
                raw.getDiscount()
        );
    }
}
