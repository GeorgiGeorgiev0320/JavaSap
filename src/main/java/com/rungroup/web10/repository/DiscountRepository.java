package com.rungroup.web10.repository;

import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rungroup.web10.models.Discount;
import com.rungroup.web10.models.Product;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    List<Discount> findByProduct(Product product);

    // Намира актуални намаления в даден диапзаон от време!
    @Query("SELECT d FROM Discount d WHERE d.startDate <= :endDate AND d.endDate >= :startDate")
    List<Discount> findActiveDiscounts(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    List<Discount> findByDiscountPercentageBetween(BigDecimal minPercentage, BigDecimal maxPercentage);
}
