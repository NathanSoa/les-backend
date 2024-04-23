package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.exceptions.MessageResolver;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CardValidator implements Validator<Card> {

    private final MessageResolver messageResolver;
    private List<String> codes;

    public CardValidator(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    @Override
    public Map<String, List<String>> validate(Card object) {
        codes = new ArrayList<>();
        validateType(object.getType());
        validateNumber(object.getNumber());
        validateName(object.getName());
        validateSecurityCode(object.getSecurityCode());
        validateFlag(object.getFlag());
        validateMain(object.getMain());
        return Map.of("card", messageResolver.resolve(codes));
    }

    public void validateType(String type) {
        if (type == null || type.isEmpty()) {
            codes.add("card.type");
        }
    }

    public void validateNumber(String number) {
        if (number == null || number.isEmpty()) {
            codes.add("card.number");
        }
    }

    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            codes.add("card.name");
        }
    }

    public void validateSecurityCode(String securityCode) {
        if (securityCode == null || securityCode.isEmpty()) {
            codes.add("card.securityCode");
        }
    }

    public void validateFlag(String flag) {
        if (flag == null || flag.isEmpty()) {
            codes.add("card.flag");
        }
    }

    public void validateMain(Boolean main) {
        if (main == null) {
            codes.add("card.main");
        }
    }
}
