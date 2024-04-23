package br.com.nathan.ecommerce.main.modules.product.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.product.controller.presentationModel.ProductPM;
import br.com.nathan.ecommerce.main.modules.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductPM implements Mapper<Product, ProductPM> {

    @Override
    public ProductPM map(Product raw) {
        return new ProductPM(
            raw.getId(),
            raw.getName(),
            raw.getPrice()
        );
    }
}
