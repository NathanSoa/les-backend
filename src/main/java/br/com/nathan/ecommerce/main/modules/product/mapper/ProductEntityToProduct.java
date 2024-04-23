package br.com.nathan.ecommerce.main.modules.product.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.product.domain.Product;
import br.com.nathan.ecommerce.main.modules.product.repository.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityToProduct implements Mapper<ProductEntity, Product> {

    @Override
    public Product map(ProductEntity raw) {
        return Product.Create()
                .withActive(raw.getActive())
                .withId(raw.getId())
                .withName(raw.getName())
                .withPrice(raw.getPrice());
    }
}
