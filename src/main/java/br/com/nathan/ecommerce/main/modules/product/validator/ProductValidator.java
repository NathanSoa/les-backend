package br.com.nathan.ecommerce.main.modules.product.validator;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.product.domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static br.com.nathan.ecommerce.main.core.utils.Utils.createErrorMap;

@Component
public class ProductValidator implements Validator<Product> {

    @Qualifier("nameValidator")
    private final Validator<String> nameValidator;

    @Qualifier("priceValidator")
    private final Validator<Double> priceValidator;

    public ProductValidator(Validator<String> nameValidator,
                            Validator<Double> priceValidator) {
        this.nameValidator = nameValidator;
        this.priceValidator = priceValidator;
    }

    @Override
    public Map<String, List<String>> validate(Product object) {
        var nameErrors = nameValidator.validate(object.getName());
        var priceErrors = priceValidator.validate(object.getPrice());

        return createErrorMap(nameErrors, priceErrors);
    }
}
