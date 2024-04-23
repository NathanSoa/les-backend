package br.com.nathan.ecommerce.main.modules.product.validator;

import br.com.nathan.ecommerce.main.core.exceptions.MessageResolver;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
@Qualifier("priceValidator")
public class PriceValidator implements Validator<Double> {
    private final MessageResolver messageResolver;

    @Override
    public Map<String, List<String>> validate(Double price) {
        var codes = new ArrayList<String>();
        if(price == null || price <= 0) {
            codes.add("product.price.required");
        }
        return Map.of("price", messageResolver.resolve(codes));
    }
}
