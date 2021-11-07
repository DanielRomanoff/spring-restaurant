package ru.restaurant.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.restaurant.db.dao.Dish;
import ru.restaurant.db.dao.JoinedDishProduct;

import java.util.List;

@Repository
public interface JoinedDishProductRepository extends CrudRepository<JoinedDishProduct, Integer> {
    List<JoinedDishProduct> findAll();

    default Dish findByDishId(Integer id) {
        return findAll().stream()
                .filter(joinedDishProduct -> joinedDishProduct.getDish().getId().equals(id)).findFirst()
                .map(JoinedDishProduct::getDish)
                .orElse(null);
    }
}