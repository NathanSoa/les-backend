package br.com.nathan.ecommerce.main.modules.cardFlag.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.cardFlag.repository.entity.FlagEntity;
import br.com.nathan.ecommerce.main.modules.cardFlag.repository.jpa.FlagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class FlagDAO implements IDAO<FlagEntity> {

    private final FlagRepository repository;


    @Override
    public FlagEntity save(FlagEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public FlagEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("flag.not-found"));
    }

    @Override
    public Set<FlagEntity> findAll() {
        return new HashSet<>(repository.findAll());
    }
}
