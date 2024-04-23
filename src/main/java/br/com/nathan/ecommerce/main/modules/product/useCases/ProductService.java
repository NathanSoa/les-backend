package br.com.nathan.ecommerce.main.modules.product.useCases;

import br.com.nathan.ecommerce.main.core.domain.AbstractService;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.product.domain.Product;
import br.com.nathan.ecommerce.main.modules.product.repository.dao.ProductDAO;
import br.com.nathan.ecommerce.main.modules.product.repository.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<Product, ProductEntity> {


    public ProductService(
            IDAO<ProductEntity> dao,
            Mapper<Product, ProductEntity> mapperToEntity,
            Mapper<ProductEntity, Product> mapperToDomain,
            Validator<Product> validator
    ) {
        super(dao, mapperToEntity, mapperToDomain, validator);
    }

    public Product findBySlug(String slug) {
        ProductEntity productEntity = ((ProductDAO) dao).findBySlug(slug);
        return mapperToDomain.map(productEntity);
    }
}
