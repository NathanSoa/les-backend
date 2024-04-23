package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.exceptions.MessageResolver;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.nathan.ecommerce.main.config.constants.ValidationConstants.PHONE_FORMAT;

@Component
@AllArgsConstructor
@Qualifier("phoneValidator")
public class PhoneValidator implements Validator<String> {

    private final MessageResolver messageResolver;

    @Override
    public Map<String, List<String>> validate(String object) {
        var codes = new ArrayList<String>();

        if(object == null || object.isBlank() || object.isEmpty()) {
            codes.add("customer.phone.required");
        } else
        if(!object.matches(PHONE_FORMAT)) {
            codes.add("customer.phone.invalid");
        }
        return Map.of("phone", messageResolver.resolve(codes));
    }
}
