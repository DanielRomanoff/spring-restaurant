package ru.restaurant.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.restaurant.db.Meal;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Integer> {
    List<Meal> findAll();
}
