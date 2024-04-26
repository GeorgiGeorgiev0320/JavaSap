package com.rungroup.web10.models;

import com.rungroup.web10.services.ProductService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId = id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private String ImageUrl;
    private Long rating;
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;
    @ManyToOne
    private Category category;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @CreationTimestamp
    private LocalDateTime updatedOn;

}