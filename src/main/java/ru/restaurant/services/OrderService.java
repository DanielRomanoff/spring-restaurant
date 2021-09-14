package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import ru.restaurant.db.Order;
import ru.restaurant.db.repositories.OrderRepository;

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

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    public Integer getTotalCost(Integer id) {
        return orderRepository.findAll().stream()
                .filter((o) -> o.getId().equals(id))
                .mapToInt((m) -> m.getMeals().stream()
                        .mapToInt((s) -> Integer.parseInt(s.getCost()))
                        .sum()).sum();
    }
}
