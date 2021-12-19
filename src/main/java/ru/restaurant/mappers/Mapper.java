package ru.restaurant.mappers;

import ru.restaurant.db.dao.RestaurantEntity;
import ru.restaurant.dto.Dto;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T extends Dto, S extends RestaurantEntity> {

    T mapToDto(S entity);

    default List<T> mapToDto(List<S> entities) {
        return entities.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    S mapToEntity(T dto);

    default List<S> mapToEntity(List<T> dto) {
        return dto.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

}
