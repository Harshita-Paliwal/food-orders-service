package com.example.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class OrderRequest {
    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotEmpty(message = "Items list cannot be empty")
    private List<ItemDto> items;

    @NotNull(message = "Total amount is required")
    @PositiveOrZero(message = "Total amount must be non-negative")
    private BigDecimal totalAmount;

    // Optional: client may send; if null, server sets to now()
    private Instant orderTime;

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public List<ItemDto> getItems() { return items; }
    public void setItems(List<ItemDto> items) { this.items = items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public Instant getOrderTime() { return orderTime; }
    public void setOrderTime(Instant orderTime) { this.orderTime = orderTime; }
}
