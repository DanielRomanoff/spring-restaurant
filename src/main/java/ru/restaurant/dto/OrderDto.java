package ru.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Заказ
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Dto {
    private Integer id;
    private List<DishDto> dish;     // Список блюд
    private Double amount;       // Сумма
}