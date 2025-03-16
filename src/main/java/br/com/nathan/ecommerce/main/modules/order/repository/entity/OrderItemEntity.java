package br.com.nathan.ecommerce.main.modules.order.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.modules.items.domain.Item;
import br.com.nathan.ecommerce.main.modules.items.repository.entity.ItemEntity;
import br.com.nathan.ecommerce.main.modules.order.domain.Order;
import br.com.nathan.ecommerce.main.modules.order.domain.OrderItem;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrderItemEntity extends BaseEntity {

    @ManyToOne
    private OrderEntity order;

    @ManyToOne
    private ItemEntity item;

    public OrderItemEntity withId(Long id) {
        this.setId(id);
        return this;
    }

    public OrderItemEntity withOrder(OrderEntity order) {
        this.order = order;
        return this;
    }

    public OrderItemEntity withItem(ItemEntity item) {
        this.item = item;
        return this;
    }
}
