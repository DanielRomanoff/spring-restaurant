package ru.restaurant.mappers;

import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Dish;
import ru.restaurant.dto.DishDto;

@Service
public class DishMapper implements Mapper<DishDto, Dish>{

    @Override
    public DishDto mapToDto(Dish entity) {
        return DishDto.builder()
                .id(entity.getId())
                .cost(entity.getCost())
                .name(entity.getName())
                .menu(entity.getMenu())
                .products(entity.getProducts())
                .build();
    }

    @Override
    public Dish mapToEntity(DishDto dto) {
        return Dish.builder()
                .id(dto.getId())
                .cost(dto.getCost())
                .name(dto.getName())
                .menu(dto.getMenu())
                .products(dto.getProducts())
                .build();
    }
}
