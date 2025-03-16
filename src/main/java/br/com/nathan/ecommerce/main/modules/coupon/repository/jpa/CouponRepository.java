package br.com.nathan.ecommerce.main.modules.coupon.repository.jpa;

import br.com.nathan.ecommerce.main.modules.coupon.repository.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
    Optional<CouponEntity> findByCodeAndActiveTrue(String code);
}
