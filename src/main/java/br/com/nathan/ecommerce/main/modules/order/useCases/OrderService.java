package br.com.nathan.ecommerce.main.modules.order.useCases;

import br.com.nathan.ecommerce.main.modules.coupon.repository.jpa.CouponRepository;
import br.com.nathan.ecommerce.main.modules.customer.repository.dao.CustomerDAO;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.AddressRepository;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.CardRepository;
import br.com.nathan.ecommerce.main.modules.order.controller.dto.PlaceOrderDTO;
import br.com.nathan.ecommerce.main.modules.order.domain.Order;
import br.com.nathan.ecommerce.main.modules.order.mapper.OrderEntityToOrder;
import br.com.nathan.ecommerce.main.modules.order.repository.dao.OrderDAO;
import br.com.nathan.ecommerce.main.modules.order.repository.entity.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderDAO orderDAO;
    private AddressRepository addressRepository;
    private CardRepository cardRepository;
    private CouponRepository couponRepository;
    private CustomerDAO customerDAO;
    private OrderEntityToOrder orderEntityToOrder;

    public Order findById(Long id) {
        return this.orderEntityToOrder.map(this.orderDAO.findById(id));
    }

    public List<Order> findAll() {
        return this.orderDAO.findAll().stream().map(this.orderEntityToOrder::map).toList();
    }

    public void placeOrder(PlaceOrderDTO placeOrderDTO) {
        var address = this.addressRepository.findById(placeOrderDTO.addressId()).orElseThrow();
        var coupon = this.couponRepository.findById(placeOrderDTO.couponId()).orElseThrow();
        var customer = this.customerDAO.findById(placeOrderDTO.customerId());
        var cards = this.cardRepository.findAllById(placeOrderDTO.cardIds());

        // criar logica para buscar items e colocar no carrinho

        var order = new OrderEntity();
        order.withAddress(address)
                .withCoupon(coupon)
                .withCustomer(customer)
                .withCards(cards);
    }
}
