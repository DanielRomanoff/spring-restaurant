package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.db.Meal;
import ru.restaurant.db.Product;
import ru.restaurant.db.repositories.MealRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;

    public Meal createMeal(List<Product> product, Meal meal) {
        final Meal createMeal = new Meal();
        createMeal.setName(meal.getName());
        createMeal.getProducts().addAll(product);
        return mealRepository.save(createMeal);
    }

    public List<Meal> getMeals() {
        return mealRepository.findAll();
    }
}
