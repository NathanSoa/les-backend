package br.com.nathan.ecommerce.main.modules.order.domain;

import br.com.nathan.ecommerce.main.modules.coupon.domain.Coupon;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Long id;
    private OrderStatus status;
    private Double total;
    private Coupon coupon;
    private Customer customer;
    private List<Card> cards;
    private Address address;
    private List<OrderItem> orderItems;

    private Order() { }

    public static Order Create() {
        return new Order();
    }

    public Order withId(Long id) {
        this.id = id;
        return this;
    }

    public Order withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public Order withTotal(Double total) {
        this.total = total;
        return this;
    }

    public Order withCoupon(Coupon coupon) {
        this.coupon = coupon;
        return this;
    }

    public Order withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Order withCards(List<Card> cards) {
        this.cards = cards;
        return this;
    }

    public Order withAddress(Address address) {
        this.address = address;
        return this;
    }

    public Order withOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }
}
