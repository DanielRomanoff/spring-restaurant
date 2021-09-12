package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.db.Meal;
import ru.restaurant.db.repositories.MealRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MealSercive {

    private final MealRepository mealRepository;

    public Meal createMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public List<Meal> getMeals() {
        return mealRepository.findAll();
    }
}
