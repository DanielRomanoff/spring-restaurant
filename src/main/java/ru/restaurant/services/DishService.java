package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Dish;
import ru.restaurant.db.repository.DishRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish updateDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public void deleteDish(Integer id) {
        dishRepository.deleteById(id);
    }

    public List<Dish> menu(List<Dish> dish) {
        List<Dish> dishes = dish.stream()
                .peek(e -> e.setMenu(Boolean.TRUE))
                .collect(Collectors.toList());
        dishRepository.saveAll(dishes);
        return dishes;
    }

    public List<Dish> getDishes() {
        return dishRepository.findAll();
    }
}
