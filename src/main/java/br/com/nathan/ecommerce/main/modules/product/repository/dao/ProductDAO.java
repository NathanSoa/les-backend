package br.com.nathan.ecommerce.main.modules.product.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.product.repository.entity.ProductEntity;
import br.com.nathan.ecommerce.main.modules.product.repository.jpa.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class ProductDAO implements IDAO<ProductEntity> {
    private final ProductRepository repository;

    @Override
    public ProductEntity save(ProductEntity entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public ProductEntity findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("product.not-found"));
    }

    @Override
    public Set<ProductEntity> findAll() {
        return new HashSet<>(this.repository.findAll());
    }

    public ProductEntity findBySlug(String slug) {
        return this.repository.findBySlug(slug).orElseThrow(() -> new EntityNotFoundException("product.not-found"));
    }
}
