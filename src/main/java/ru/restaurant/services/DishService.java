package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Dish;
import ru.restaurant.db.dao.JoinedDishProduct;
import ru.restaurant.db.dao.Product;
import ru.restaurant.db.repository.DishRepository;
import ru.restaurant.db.repository.JoinedDishProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final JoinedDishProductRepository joinedDishProductRepository;

    public Dish createDish(Dish dish) {
        Dish savedDish = dishRepository.save(dish);
        List<Product> products = savedDish.getProducts();
        List<JoinedDishProduct> joinedDishProducts = joinedDishProductRepository.findByDishId(savedDish.getId());

        for (int i = 0; i < joinedDishProducts.size() && i < products.size(); i++) {
            joinedDishProductRepository.save(JoinedDishProduct.builder()
                    .id(joinedDishProducts.get(i).getId())
                    .dish(savedDish)
                    .product(products.get(i))
                    .numberOfProductsForDish(dish.getProductCountMap().get(products.get(i).getId()))
                    .build());
        }

        return savedDish;
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
