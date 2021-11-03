package ru.restaurant.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.restaurant.dao.Order;
import ru.restaurant.dto.OrderDto;

@Service
@AllArgsConstructor
public class OrderMapper implements Mapper<OrderDto, Order> {

    private final WaiterMapper waiterMapper;

    @Override
    public OrderDto mapToDto(Order entity) {
        return OrderDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .dish(entity.getDish())
                .waiterDto(waiterMapper.mapToDto(entity.getWaiter()))
                .status(entity.getStatus())
                .build();
    }

    @Override
    public Order mapToEntity(OrderDto dto) {
        return Order.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .dish(dto.getDish())
                .waiter(waiterMapper.mapToEntity(dto.getWaiterDto()))
                .status(dto.getStatus())
                .build();
    }
}
