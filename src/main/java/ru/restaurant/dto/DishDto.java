package ru.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.restaurant.dao.Product;

import java.util.List;

// Блюдо
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishDto implements Dto{
    private Integer id;
    private String name;
    private String cost;
    private List<Product> products; // Список продуктов для блюда
    private Boolean menu; // В меню ли блюдо
}