package br.com.nathan.ecommerce.main.modules.order.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.modules.coupon.repository.entity.CouponEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CardEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.order.domain.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "order")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotNull
    private Double total;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private CouponEntity coupon;

    @ManyToOne
    @JoinColumn(name = "costumer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToMany
    @JoinTable(
            name = "order_card",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<CardEntity> cards;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderItemEntity> orderItems;

    public OrderEntity withId(Long id) {
        this.setId(id);
        return this;
    }

    public OrderEntity withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public OrderEntity withTotal(Double total) {
        this.total = total;
        return this;
    }

    public OrderEntity withCoupon(CouponEntity coupon) {
        this.coupon = coupon;
        return this;
    }

    public OrderEntity withCustomer(CustomerEntity customer) {
        this.customer = customer;
        return this;
    }

    public OrderEntity withCards(List<CardEntity> cards) {
        this.cards = cards;
        return this;
    }

    public OrderEntity withAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public OrderEntity withOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
        return this;
    }
}
