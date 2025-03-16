package br.com.nathan.ecommerce.main.modules.order.repository.jpa;

import br.com.nathan.ecommerce.main.modules.order.repository.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
