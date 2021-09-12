package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.db.Meal;
import ru.restaurant.db.repositories.MealRepository;
import ru.restaurant.services.MealSercive;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final MealSercive mealSercive;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Meal> meals() {
        log.info("Get meals");
        return mealSercive.getMeals();
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Meal createMeal(@Valid @RequestBody Meal meal) {
        log.info("Create meal - {}", meal);
        return mealSercive.createMeal(meal);
    }
}

