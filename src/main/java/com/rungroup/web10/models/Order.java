<<<<<<< HEAD
package com.rungroup.web10.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalPrice;
    private String shippingAddress;
    private String paymentMethod;
}
=======
package com.rungroup.web10.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalPrice;
    private String shippingAddress;
    private String paymentMethod;
}
>>>>>>> 0c286376bfa15b62ea6c1f81eccf1b1faa37de3a
