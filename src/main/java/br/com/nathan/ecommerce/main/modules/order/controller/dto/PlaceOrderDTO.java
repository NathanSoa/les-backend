package br.com.nathan.ecommerce.main.modules.order.controller.dto;

import java.util.List;

public record PlaceOrderDTO (
        Long customerId,
        Long addressId,
        List<Long> cardIds,
        List<OrderItemDTO> orderItems,
        Long couponId,
        Double total

) {
    public record OrderItemDTO(
            Long productId,
            Integer quantity
    ) { }
}
