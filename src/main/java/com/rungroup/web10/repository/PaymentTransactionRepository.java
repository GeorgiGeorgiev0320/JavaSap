package com.rungroup.web10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroup.web10.models.Order;
import com.rungroup.web10.models.PaymentTransaction;

import java.util.List;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
    List<PaymentTransaction> findByOrder(Order order);
}

