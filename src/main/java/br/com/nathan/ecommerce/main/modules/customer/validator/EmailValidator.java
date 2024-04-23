package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.exceptions.MessageResolver;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Qualifier("emailValidator")
@AllArgsConstructor
public class EmailValidator implements Validator<String> {

    private MessageResolver messageResolver;

    @Override
    public Map<String, List<String>> validate(String email) {
        var emailValidator = new org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator();
        var codes = new ArrayList<String>();

        if(email == null || email.isBlank() || email.isEmpty()) {
            codes.add("customer.email.required");
        } else
        if(!emailValidator.isValid(email, null)) {
            codes.add("customer.email.invalid");
        }
        return Map.of("email", messageResolver.resolve(codes));
    }
}
