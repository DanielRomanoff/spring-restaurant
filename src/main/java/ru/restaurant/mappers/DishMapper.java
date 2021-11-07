package ru.restaurant.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Dish;
import ru.restaurant.db.dao.Product;
import ru.restaurant.dto.DishDto;
import ru.restaurant.dto.ProductDto;

@Service
@RequiredArgsConstructor
public class DishMapper implements Mapper<DishDto, Dish> {

    private final ProductMapper mapper;

    @Override
    public DishDto mapToDto(Dish entity) {
        return DishDto.builder()
                .id(entity.getId())
                .cost(entity.getCost())
                .name(entity.getName())
                .menu(entity.getMenu())
                .products(mapper.mapToDto(entity.getProducts()))
                .build();
    }

    @Override
    public Dish mapToEntity(DishDto dto) {
        List<ProductDto> products = dto.getProducts();
        Map<Integer, Integer> productIntegerMap = new HashMap<>();
        products.forEach(product -> productIntegerMap.put(product.getId(), product.getCount()));
        return Dish.builder()
                .id(dto.getId())
                .cost(dto.getCost())
                .name(dto.getName())
                .menu(dto.getMenu())
                .products(mapper.mapToEntity(products))
                .productCountMap(productIntegerMap)
                .build();
    }
}
