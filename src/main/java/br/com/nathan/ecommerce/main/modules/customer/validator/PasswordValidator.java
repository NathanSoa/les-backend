package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.exceptions.MessageResolver;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.nathan.ecommerce.main.config.constants.ValidationConstants.PASSWORD_MAX_LENGTH;
import static br.com.nathan.ecommerce.main.config.constants.ValidationConstants.PASSWORD_MIN_LENGTH;

@Component
@AllArgsConstructor
@Qualifier("passwordValidator")
public class PasswordValidator implements Validator<String> {

    private final MessageResolver messageResolver;

    @Override
    public Map<String, List<String>> validate(String object) {
        var codes = new ArrayList<String>();
        if (object == null || object.isBlank() || object.isEmpty()) {
            codes.add("customer.password.required");
        } else {
            if (object.length() < PASSWORD_MIN_LENGTH ||
                    object.length() > PASSWORD_MAX_LENGTH) {
                codes.add("customer.password.size");
            }
            if (!object.matches(".*[A-Z].*")) {
                codes.add("customer.password.uppercase");
            }
            if (!object.matches(".*[^a-zA-Z0-9].*")) {
                codes.add("customer.password.special");
            }
        }
        return Map.of("password", messageResolver.resolve(codes));
    }
}
