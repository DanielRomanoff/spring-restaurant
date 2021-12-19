package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Order;
import ru.restaurant.db.repository.OrderRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Double getAmount() {
        return orderRepository.findAll().stream()
                .mapToDouble(Order::getAmount)
                .sum();
    }

    public void changeOrderStatus(Order order) {
        orderRepository.save(order);
    }
}
