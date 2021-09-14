package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.db.Order;
import ru.restaurant.db.Person;
import ru.restaurant.services.OrderService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Order> orders() {
        log.info("Get orders");
        return orderService.getOrders();
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Order createOrder(@Valid @RequestBody Order order) {
        log.info("Create order = {}", order);
        return orderService.createOrder(order);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE)
    public void deleteOrder(@RequestBody Order order) {
        log.info("Delete person = {}", order);
        orderService.deleteOrder(order);
    }

    @GetMapping("/cost")
    public Integer totalCost(@RequestParam(name = "id") Integer id) {
        log.info("Get total cost of order with id = " + id);
        return orderService.getTotalCost(id);
    }
}
