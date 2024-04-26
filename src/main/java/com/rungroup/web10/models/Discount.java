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
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private BigDecimal discountPercentage;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
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
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private BigDecimal discountPercentage;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
>>>>>>> 0c286376bfa15b62ea6c1f81eccf1b1faa37de3a
