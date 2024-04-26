package com.rungroup.web10.dto;

import lombok.Data;
import lombok.Builder;
import jakarta.validation.constraints.NotEmpty;

@Data
@Builder
public class CategoryDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty!")
    private String name;
}

