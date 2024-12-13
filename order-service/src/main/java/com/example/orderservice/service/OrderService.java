package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        // Get authenticated user's ID from security context
        Long authenticatedUserId = (Long) SecurityContextHolder.getContext()
            .getAuthentication().getDetails();
            
        // Verify that the order's userId matches the authenticated user
        if (!authenticatedUserId.equals(order.getUserId())) {
            throw new RuntimeException("You can only create orders for yourself");
        }
        
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        // Get authenticated user's ID from security context
        Long authenticatedUserId = (Long) SecurityContextHolder.getContext()
            .getAuthentication().getDetails();
            
        // Verify that the requested userId matches the authenticated user
        if (!authenticatedUserId.equals(userId)) {
            throw new RuntimeException("You can only view your own orders");
        }
        
        return orderRepository.findByUserId(userId);
    }

    public List<Order> getAllOrders() {
        throw new RuntimeException("This operation is not allowed");
    }
}