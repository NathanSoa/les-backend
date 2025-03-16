package br.com.nathan.ecommerce.main.modules.coupon.useCases;

import br.com.nathan.ecommerce.main.modules.coupon.domain.Coupon;
import br.com.nathan.ecommerce.main.modules.coupon.mapper.CouponEntityToCoupon;
import br.com.nathan.ecommerce.main.modules.coupon.repository.dao.CouponDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CouponService {
    private final CouponDAO dao;
    private final CouponEntityToCoupon mapper;

    public Coupon findByCode(String code) {
        return this.mapper.map(
                dao.findByCode(code)
        );
    }
}
