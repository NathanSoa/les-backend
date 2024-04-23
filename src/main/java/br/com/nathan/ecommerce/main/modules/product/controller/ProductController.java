package br.com.nathan.ecommerce.main.modules.product.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.infra.http.AbstractController;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.product.controller.dto.ProductDTO;
import br.com.nathan.ecommerce.main.modules.product.controller.presentationModel.ProductPM;
import br.com.nathan.ecommerce.main.modules.product.domain.Product;
import br.com.nathan.ecommerce.main.modules.product.useCases.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static br.com.nathan.ecommerce.main.core.infra.http.HttpHelper.ok;

@BaseController("/products")
public class ProductController extends AbstractController<ProductDTO, Product, ProductPM> {

    @Autowired
    public ProductController(ProductService service,
                             Mapper<ProductDTO, Product> mapperToDomain,
                             Mapper<Product, ProductPM> mapperToPm) {
        super(service, mapperToDomain, mapperToPm);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> findBySlug(@PathVariable String slug) {
        return ok(Optional.of(mapperToPm.map(((ProductService) service).findBySlug(slug))));
    }
}
