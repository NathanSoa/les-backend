package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.exceptions.MessageResolver;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

import static br.com.nathan.ecommerce.main.config.constants.ValidationConstants.CPF_FORMATTED;
import static br.com.nathan.ecommerce.main.config.constants.ValidationConstants.CPF_UNFORMATTED;

@Component
@AllArgsConstructor
@Qualifier("cpfValidator")
public class CpfValidator implements Validator<String> {

    private final MessageResolver messageResolver;

    @Override
    public Map<String, List<String>> validate(String cpf) {
        var codes = new ArrayList<String>();

        if(cpf == null || cpf.isBlank() || cpf.isEmpty()) {
            codes.add("customer.cpf.required");
        } else
        if (this.isInvalid(cpf)) {
            codes.add("customer.cpf.invalid");
        }
        return Map.of("cpf", messageResolver.resolve(codes));
    }

    private boolean isInvalid(String cpf) {
        return !(cpf.matches(CPF_UNFORMATTED) || cpf.matches(CPF_FORMATTED));
    }
}
