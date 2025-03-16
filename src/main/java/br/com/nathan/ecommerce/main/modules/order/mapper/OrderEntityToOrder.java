package br.com.nathan.ecommerce.main.modules.order.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.coupon.mapper.CouponEntityToCoupon;
import br.com.nathan.ecommerce.main.modules.customer.mapper.AddressEntityToAddress;
import br.com.nathan.ecommerce.main.modules.customer.mapper.CardEntityToCard;
import br.com.nathan.ecommerce.main.modules.customer.mapper.CustomerEntityToCustomer;
import br.com.nathan.ecommerce.main.modules.order.domain.Order;
import br.com.nathan.ecommerce.main.modules.order.domain.OrderItem;
import br.com.nathan.ecommerce.main.modules.order.repository.entity.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderEntityToOrder implements Mapper<OrderEntity, Order> {
    private AddressEntityToAddress addressEntityToAddress;
    private CardEntityToCard cardEntityToCard;
    private CustomerEntityToCustomer customerEntityToCustomer;
    private CouponEntityToCoupon couponEntityToCoupon;

    @Override
    public Order map(OrderEntity raw) {
        return Order.Create()
                .withId(raw.getId())
                .withStatus(raw.getStatus())
                .withTotal(raw.getTotal())
                .withAddress(this.addressEntityToAddress.map(raw.getAddress()))
                .withCards(raw.getCards().stream().map(this.cardEntityToCard::map).toList())
                .withCustomer(this.customerEntityToCustomer.map(raw.getCustomer()))
                .withCoupon(this.couponEntityToCoupon.map(raw.getCoupon()));
    }
}
