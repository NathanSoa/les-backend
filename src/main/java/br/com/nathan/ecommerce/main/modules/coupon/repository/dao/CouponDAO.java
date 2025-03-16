package br.com.nathan.ecommerce.main.modules.coupon.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.coupon.repository.entity.CouponEntity;
import br.com.nathan.ecommerce.main.modules.coupon.repository.jpa.CouponRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class CouponDAO implements IDAO<CouponEntity> {
    private final CouponRepository repository;

    @Override
    public CouponEntity save(CouponEntity entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public CouponEntity findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("coupon.not-found"));
    }

    @Override
    public Set<CouponEntity> findAll() {
        return new HashSet<>(this.repository.findAll());
    }

    public CouponEntity findByCode(String code) {
        return this.repository.findByCodeAndActiveTrue(code).orElseThrow(() -> new EntityNotFoundException("coupon.not-found"));
    }
}
