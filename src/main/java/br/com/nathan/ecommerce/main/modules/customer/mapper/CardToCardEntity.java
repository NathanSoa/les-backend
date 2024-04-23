package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CardEntity;
import org.springframework.stereotype.Component;

@Component
public class CardToCardEntity implements Mapper<Card, CardEntity> {

    @Override
    public CardEntity map(Card raw) {
        var card = new CardEntity()
                    .withNumber(raw.getNumber())
                    .withName(raw.getName())
                    .withFlag(raw.getFlag())
                    .withType(raw.getType())
                    .withSecurityCode(raw.getSecurityCode())
                    .withMain(raw.getMain());
        card.setActive(true);
        return card;
    }
}
