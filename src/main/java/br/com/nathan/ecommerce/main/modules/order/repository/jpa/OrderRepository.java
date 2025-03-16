package br.com.nathan.ecommerce.main.modules.order.repository.jpa;

import br.com.nathan.ecommerce.main.modules.order.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
