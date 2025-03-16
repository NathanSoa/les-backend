package br.com.nathan.ecommerce.main.modules.product.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.product.domain.Product;
import br.com.nathan.ecommerce.main.modules.product.repository.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductEntity implements Mapper<Product, ProductEntity> {

    @Override
    public ProductEntity map(Product raw) {
        var productEntity = new ProductEntity();

        return productEntity.withName(raw.getName())
            .withPrice(raw.getPrice())
            .withActive(raw.isActive())
            .withPhotoUrl(raw.getPhotoUrl());
    }
}
