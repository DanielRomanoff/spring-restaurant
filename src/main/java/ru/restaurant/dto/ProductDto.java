package ru.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Продукт
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Dto {
    private Integer id;
    private String name;
    private Integer count; // Количество
    @JsonIgnore
    private List<DishDto> dishes;
}