package ru.restaurant.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Dish;
import ru.restaurant.dto.DishDto;

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
        return Dish.builder()
                .id(dto.getId())
                .cost(dto.getCost())
                .name(dto.getName())
                .menu(dto.getMenu())
                .products(mapper.mapToEntity(dto.getProducts()))
                .build();
    }
}
