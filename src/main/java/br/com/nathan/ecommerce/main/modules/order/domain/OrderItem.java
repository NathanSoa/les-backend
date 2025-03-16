package br.com.nathan.ecommerce.main.modules.order.domain;

import br.com.nathan.ecommerce.main.modules.items.domain.Item;
import lombok.Data;

@Data
public class OrderItem {
    private Long id;
    private Order order;
    private Item item;

    private OrderItem() { }

    public static OrderItem Create() {
        return new OrderItem();
    }

    public OrderItem withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderItem withOrder(Order order) {
        this.order = order;
        return this;
    }

    public OrderItem withItem(Item item) {
        this.item = item;
        return this;
    }
}
