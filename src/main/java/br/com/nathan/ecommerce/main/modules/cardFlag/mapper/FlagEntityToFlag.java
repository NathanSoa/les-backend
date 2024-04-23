package br.com.nathan.ecommerce.main.modules.cardFlag.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.cardFlag.domain.Flag;
import br.com.nathan.ecommerce.main.modules.cardFlag.repository.entity.FlagEntity;
import org.springframework.stereotype.Component;

@Component
public class FlagEntityToFlag implements Mapper<FlagEntity, Flag> {

    @Override
    public Flag map(FlagEntity raw) {
        return Flag.Create()
                .withName(raw.getName());
    }
}
