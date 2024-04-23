package br.com.nathan.ecommerce.main.modules.product.repository.jpa;

import br.com.nathan.ecommerce.main.modules.product.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findBySlug(String slug);
}
