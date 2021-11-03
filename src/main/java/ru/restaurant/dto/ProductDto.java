package ru.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Продукт
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Dto {
    private Integer id;
    private String name;
    private Integer count; // Количество
}