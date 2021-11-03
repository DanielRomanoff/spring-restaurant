package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.dao.Product;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {


    public Product createProduct(Product product) {
        return null;
    }

    public List<Product> getProducts() {
        return null;
    }

    public Product addProductCount(Product productDto, Integer count) {
        return null;
    }
}
