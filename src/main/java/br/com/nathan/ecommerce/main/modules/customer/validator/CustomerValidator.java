package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.nathan.ecommerce.main.core.utils.Utils.createErrorMap;

@Component
public class CustomerValidator implements Validator<Customer> {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerValidator.class);


    @Qualifier("cpfValidator")
    private final Validator<String> cpfValidator;
    @Qualifier("emailValidator")
    private final Validator<String> emailValidator;
    @Qualifier("passwordValidator")
    private final Validator<String> passwordValidator;
    @Qualifier("nameValidator")
    private final Validator<String> nameValidator;
    @Qualifier("phoneValidator")
    private final Validator<String> phoneValidator;
    private final Validator<Address> addressValidator;
    private final Validator<Card> cardValidator;

    public CustomerValidator(
        Validator<String> cpfValidator,
        Validator<String> emailValidator,
        Validator<String> passwordValidator,
        Validator<String> nameValidator,
        Validator<String> phoneValidator,
        Validator<Address> addressValidator,
        Validator<Card> cardValidator
    ) {
        this.cpfValidator = cpfValidator;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
        this.nameValidator = nameValidator;
        this.phoneValidator = phoneValidator;
        this.addressValidator = addressValidator;
        this.cardValidator = cardValidator;
    }

    @Override
    public Map<String, List<String>> validate(Customer object) {
        return this.executeValidations(object);
    }

    private Map<String, List<String>> executeValidations(Customer object) {
        logger.info("Validating customer {}", object);

        var cpfErrors = cpfValidator.validate(object.getCpf().getValue());
        var emailErrors = emailValidator.validate(object.getEmail().getValue());
        var passwordErrors = passwordValidator.validate(object.getPassword().getValue());
        var nameErrors = nameValidator.validate(object.getName().getValue());
        var phoneErrors = phoneValidator.validate(object.getPhone().getValue());
        var addressErrors = this.validateAddresses(object.getAddress());
        var cardErrors = this.validateCards(object.getCard());

        return createErrorMap(cpfErrors,
                emailErrors,
                passwordErrors,
                nameErrors,
                phoneErrors,
                addressErrors,
                cardErrors
        );
    }

    private Map<String, List<String>> validateAddresses(List<Address> addresses) {
        var errorMap = new HashMap<String, List<String>>();
        addresses.forEach(address -> {
            var errors = addressValidator.validate(address);
            errorMap.putAll(errors);
        });
        return errorMap;
    }

    private Map<String, List<String>> validateCards(List<Card> cards) {
        var errorMap = new HashMap<String, List<String>>();
        cards.forEach(card -> {
            var errors = cardValidator.validate(card);
            errorMap.putAll(errors);
        });
        return errorMap;
    }
}
