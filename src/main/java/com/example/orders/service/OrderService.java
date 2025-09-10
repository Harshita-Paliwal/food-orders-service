package com.example.orders.service;

import com.example.orders.dto.ItemDto;
import com.example.orders.dto.OrderRequest;
import com.example.orders.dto.OrderResponse;
import com.example.orders.model.OrderEntity;
import com.example.orders.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderRequest req) {
        // Basic server-side validation: total matches sum(items) within 2 decimals
        @SuppressWarnings("deprecation")
		BigDecimal computed = req.getItems().stream()
                .map(i -> i.getUnitPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);

        @SuppressWarnings("deprecation")
		BigDecimal sent = req.getTotalAmount().setScale(2, BigDecimal.ROUND_HALF_UP);
        if (computed.compareTo(sent) != 0) {
            throw new IllegalArgumentException("totalAmount (" + sent + ") does not match sum(items) (" + computed + ")");
        }

        OrderEntity e = new OrderEntity();
        e.setCustomerName(req.getCustomerName().trim());
        e.setItems(req.getItems());
        e.setTotalAmount(sent);
        e.setOrderTime(req.getOrderTime() != null ? req.getOrderTime() : Instant.now());

        OrderEntity saved = orderRepository.save(e);
        return new OrderResponse(saved.getId(), saved.getCustomerName(), saved.getItems(), saved.getTotalAmount(), saved.getOrderTime());
    }

    public Page<OrderResponse> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable)
                .map(o -> new OrderResponse(o.getId(), o.getCustomerName(), o.getItems(), o.getTotalAmount(), o.getOrderTime()));
    }
}
