package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.db.Meal;
import ru.restaurant.services.MealService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final MealService mealService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Meal> meals() {
        log.info("Get meals");
        return mealService.getMeals();
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Meal createMeal(@Valid @RequestBody Meal meal) {
        log.info("Create meal - {}", meal);
        return mealService.createMeal(meal);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE)
    public void deleteMeal(@RequestBody Meal meal) {
        log.info("Delete meal - {}", meal);
        mealService.deleteMeal(meal);
    }
}
