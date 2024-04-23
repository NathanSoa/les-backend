package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.core.exceptions.MessageResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.nathan.ecommerce.main.config.constants.ValidationConstants.NAME_MAX_LENGTH;
import static br.com.nathan.ecommerce.main.config.constants.ValidationConstants.NAME_MIN_LENGTH;

@Component
@Qualifier("nameValidator")
public class NameValidator implements Validator<String> {

    private final MessageResolver messageResolver;

    public NameValidator(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    @Override
    public Map<String, List<String>> validate(String name) {
        var codes = new ArrayList<String>();
        if(name == null || name.isBlank() || name.isEmpty()) {
            codes.add("customer.name.required");
        } else
        if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            codes.add("customer.name.size");
        }
        return Map.of("name", messageResolver.resolve(codes));
    }
}
