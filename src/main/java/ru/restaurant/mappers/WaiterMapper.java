package ru.restaurant.mappers;

import org.springframework.stereotype.Service;
import ru.restaurant.dao.Waiter;
import ru.restaurant.dto.WaiterDto;

@Service
public class WaiterMapper implements Mapper<WaiterDto, Waiter> {
    @Override
    public WaiterDto mapToDto(Waiter entity) {
        return WaiterDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Waiter mapToEntity(WaiterDto dto) {
        return Waiter.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
