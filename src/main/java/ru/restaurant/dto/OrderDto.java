package ru.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.restaurant.dao.Dish;
import ru.restaurant.enums.Status;

import java.util.List;

// Заказ
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Dto {
    private Integer id;
    private List<Dish> dish;     // Список блюд
    private WaiterDto waiterDto; // Официант
    private Double amount;       // Сумма
    private Status status;       // Статус заказа
}