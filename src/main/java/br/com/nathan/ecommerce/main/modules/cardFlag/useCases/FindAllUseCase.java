package br.com.nathan.ecommerce.main.modules.cardFlag.useCases;

import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.cardFlag.domain.Flag;
import br.com.nathan.ecommerce.main.modules.cardFlag.repository.entity.FlagEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service("FindAllFlagsUseCase")
@AllArgsConstructor
public class FindAllUseCase {

    private final IDAO<FlagEntity> repository;
    private final Mapper<FlagEntity, Flag> mapper;

    public Set<Flag> execute() {
        return repository.findAll()
                .stream().map(mapper::map)
                .collect(Collectors.toSet());
    }
}
