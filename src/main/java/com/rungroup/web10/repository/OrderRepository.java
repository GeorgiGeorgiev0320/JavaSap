package com.rungroup.web10.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rungroup.web10.models.Order;
import com.rungroup.web10.models.UserEntity;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(UserEntity user);

    List<Order> findByStatus(String status);

    // Намира поръчки в даден диапазон от време!
    @Query("SELECT o FROM Order o WHERE o.orderDate >= :startDate AND o.orderDate <= :endDate")
    List<Order> findOrdersByDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    List<Order> findByTotalPriceGreaterThan(BigDecimal totalPrice);

    List<Order> findByUserAndStatus(UserEntity user, String status);
}

