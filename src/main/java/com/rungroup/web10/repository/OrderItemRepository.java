package com.rungroup.web10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroup.web10.models.Order;
import com.rungroup.web10.models.OrderItem;
import com.rungroup.web10.models.Product;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);

    List<OrderItem> findByProduct(Product product);

    OrderItem findByOrderAndProduct(Order order, Product product);
}

