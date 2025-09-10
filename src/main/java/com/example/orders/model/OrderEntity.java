package com.example.orders.model;

import com.example.orders.util.ItemListJsonConverter;
import com.example.orders.dto.ItemDto;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "orders", indexes = {
        @Index(name = "idx_orders_order_time", columnList = "order_time"),
        @Index(name = "idx_orders_customer_name", columnList = "customer_name")
})
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Convert(converter = ItemListJsonConverter.class)
    @Column(name = "items", columnDefinition = "json", nullable = false)
    private List<ItemDto> items;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "order_time", nullable = false)
    private Instant orderTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public List<ItemDto> getItems() { return items; }
    public void setItems(List<ItemDto> items) { this.items = items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public Instant getOrderTime() { return orderTime; }
    public void setOrderTime(Instant orderTime) { this.orderTime = orderTime; }
}
