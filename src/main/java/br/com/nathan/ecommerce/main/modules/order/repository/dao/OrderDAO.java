package br.com.nathan.ecommerce.main.modules.order.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.order.repository.entity.OrderEntity;
import br.com.nathan.ecommerce.main.modules.order.repository.jpa.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class OrderDAO implements IDAO<OrderEntity> {
    private OrderRepository repository;

    @Override
    public OrderEntity save(OrderEntity entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public OrderEntity findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("order.not-found"));
    }

    @Override
    public Set<OrderEntity> findAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
