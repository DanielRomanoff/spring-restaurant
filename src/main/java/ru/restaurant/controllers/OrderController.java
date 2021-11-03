package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.dto.OrderDto;
import ru.restaurant.enums.Status;
import ru.restaurant.mappers.OrderMapper;
import ru.restaurant.services.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.Stack;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private OrderMapper mapper;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> orders() {
        log.info("Get orders");
        return ResponseEntity.ok(mapper.mapToDto(orderService.getOrders()));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
        log.info("Create order = {}", orderDto);
        return ResponseEntity.ok(mapper.mapToDto(orderService.createOrder(mapper.mapToEntity(orderDto))));
    }

    @RequestMapping("/amount")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> getAmountByOrders() {
        log.info("Get amount");
        return ResponseEntity.ok(orderService.getAmount());
    }

    @RequestMapping("/status")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> changeOrderStatus(Status status) {
        log.info("Change status = {}", status);
        return ResponseEntity.ok(mapper.mapToDto(orderService.changeStatus(status)));
    }
}
