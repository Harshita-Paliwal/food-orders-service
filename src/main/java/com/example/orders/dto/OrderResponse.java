package com.example.orders.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class OrderResponse {
    private Long id;
    private String customerName;
    private List<ItemDto> items;
    private BigDecimal totalAmount;
    private Instant orderTime;

    public OrderResponse(Long id, String customerName, List<ItemDto> items, BigDecimal totalAmount, Instant orderTime) {
        this.id = id;
        this.customerName = customerName;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
    }

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public List<ItemDto> getItems() { return items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public Instant getOrderTime() { return orderTime; }
}
