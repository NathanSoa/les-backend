package br.com.nathan.ecommerce.main.modules.product.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.product.controller.dto.ProductDTO;
import br.com.nathan.ecommerce.main.modules.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOToProduct implements Mapper<ProductDTO, Product> {

    @Override
    public Product map(ProductDTO raw) {
        return Product.Create()
                .withName(raw.name())
                .withPrice(raw.price());
    }
}
