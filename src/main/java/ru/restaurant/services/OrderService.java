package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.dao.Order;
import ru.restaurant.enums.Status;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    public Order createOrder(Order order) {
        return null;
    }

    public List<Order> getOrders() {
        return null;
    }

    public Double getAmount() {
        return null;
    }

    public Order changeStatus(Status status) {
        return null;
    }
}
