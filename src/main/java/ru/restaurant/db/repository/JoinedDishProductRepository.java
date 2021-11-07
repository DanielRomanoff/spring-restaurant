package ru.restaurant.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.restaurant.db.dao.Dish;
import ru.restaurant.db.dao.JoinedDishProduct;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface JoinedDishProductRepository extends CrudRepository<JoinedDishProduct, Integer> {
    List<JoinedDishProduct> findAll();

    default List<JoinedDishProduct> findByDishId(Integer dishId) {
        return findAll().stream()
                .filter(joinedDishProduct -> joinedDishProduct.getDish().getId().equals(dishId))
                .collect(Collectors.toList());
    }
}