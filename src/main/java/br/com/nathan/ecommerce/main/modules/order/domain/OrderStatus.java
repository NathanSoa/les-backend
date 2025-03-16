package br.com.nathan.ecommerce.main.modules.order.domain;

public enum OrderStatus {
    PENDING_PAYMENT,
    PAYMENT_ACCEPTED,
    PAYMENT_REFUSED,
    IN_PREPARATION,
    ON_THE_WAY,
    DELIVERED,
    CANCELED,
    EXCHANGED,
    EXCHANGE_REQUESTED,
    EXCHANGING,
    EXCHANGE_RECEIVED,
    EXCHANGE_COMPLETED
}