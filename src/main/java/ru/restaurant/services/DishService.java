package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.dao.Dish;
import ru.restaurant.dao.Product;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DishService {
    public Dish createDish(Dish dish) {
        return Dish.builder()
                .id(1)
                .menu(true)
                .name("Картошка с котлетами")
                .cost("300")
                .products(List.of(
                        Product.builder()
                                .id(1)
                                .name("Картошка")
                                .count(1)
                        .build(),
                        Product.builder()
                                .id(2)
                                .name("Котлета")
                                .count(2)
                                .build()
                ))
                .build();
    }

    public Dish updateDish(Dish dish) {
        return null;
    }

    public Dish deleteDish(Integer id) {
        return null;
    }

    public List<Dish> menu(List<Dish> dish) {
        return null;
    }
}
