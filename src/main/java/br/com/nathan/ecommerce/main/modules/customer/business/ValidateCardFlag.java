package br.com.nathan.ecommerce.main.modules.customer.business;

import br.com.nathan.ecommerce.main.core.exceptions.BusinessException;
import br.com.nathan.ecommerce.main.core.interfaces.Strategy;
import br.com.nathan.ecommerce.main.modules.cardFlag.useCases.FindAllUseCase;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidateCardFlag implements Strategy<List<Card>> {

    private final FindAllUseCase findAllFlags;

    public ValidateCardFlag(@Qualifier("FindAllFlagsUseCase") FindAllUseCase findAllFlags) {
        this.findAllFlags = findAllFlags;
    }

    @Override
    public String process(List<Card> object) {
        final var flags = findAllFlags.execute()
                .stream()
                .map(flag -> flag.getName().toUpperCase()).toList();

        object.forEach(card -> {
            if(!(flags.contains(card.getFlag().toUpperCase()))) {
                throw new BusinessException("card.flag.invalid");
            }
        });
        return null;
    }
}
