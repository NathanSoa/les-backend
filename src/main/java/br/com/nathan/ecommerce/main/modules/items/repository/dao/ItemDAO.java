package br.com.nathan.ecommerce.main.modules.items.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.items.repository.entity.ItemEntity;
import br.com.nathan.ecommerce.main.modules.items.repository.jpa.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class ItemDAO implements IDAO<ItemEntity> {
    private final ItemRepository repository;

    @Override
    public ItemEntity save(ItemEntity entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public ItemEntity findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("item.not-found"));
    }

    @Override
    public Set<ItemEntity> findAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
