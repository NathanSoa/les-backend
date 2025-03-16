package br.com.nathan.ecommerce.main.modules.coupon.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.coupon.domain.Coupon;
import br.com.nathan.ecommerce.main.modules.coupon.repository.entity.CouponEntity;
import org.springframework.stereotype.Component;

@Component
public class CouponEntityToCoupon implements Mapper<CouponEntity, Coupon> {
    @Override
    public Coupon map(CouponEntity raw) {
        return Coupon.Create()
                .withCode(raw.getCode())
                .withDiscount(raw.getDiscount())
                .withId(raw.getId());
    }
}
