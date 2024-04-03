package com.rungroup.web10.dto;


import com.rungroup.web10.models.Category;
import com.rungroup.web10.models.UserEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProductDto {
    private Long id;
    private Long productId;
    @NotEmpty(message = "Name cannot be empty!")
    private String name;
    @NotEmpty(message = "Description cannot be empty!")
    private String description;
    @DecimalMax(value = "10.0", message = "Max price is 10") @DecimalMin(value = "1.0", message = "Min price is 1")
    private Double price;
    @DecimalMax(value = "100.0", message = "Max quantity is 100") @DecimalMin(value = "1.0", message = "Min quantity is 1")
    private int quantity;
    @NotEmpty(message = "ImageUrl cannot be empty!")
    private String ImageUrl;
    private UserEntity createdBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
