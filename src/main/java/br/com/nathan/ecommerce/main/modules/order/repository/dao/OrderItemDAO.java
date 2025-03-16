package br.com.nathan.ecommerce.main.modules.order.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.order.repository.entity.OrderItemEntity;
import br.com.nathan.ecommerce.main.modules.order.repository.jpa.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class OrderItemDAO implements IDAO<OrderItemEntity> {
    private OrderItemRepository repository;

    @Override
    public OrderItemEntity save(OrderItemEntity entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public OrderItemEntity findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("item.not-found"));
    }

    @Override
    public Set<OrderItemEntity> findAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
