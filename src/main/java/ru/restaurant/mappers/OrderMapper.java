package ru.restaurant.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Order;
import ru.restaurant.dto.OrderDto;
import ru.restaurant.enums.Status;

@Service
@AllArgsConstructor
public class OrderMapper implements Mapper<OrderDto, Order> {

    private final DishMapper dishMapper;

    @Override
    public OrderDto mapToDto(Order entity) {
        return OrderDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .dish(dishMapper.mapToDto(entity.getDish()))
                .build();
    }

    @Override
    public Order mapToEntity(OrderDto dto) {
        return Order.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .dish(dishMapper.mapToEntity(dto.getDish()))
                .status(Status.CREATED)
                .build();
    }
}
