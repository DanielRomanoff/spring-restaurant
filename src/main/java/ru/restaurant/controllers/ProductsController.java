package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.restaurant.db.Product;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Product> products() {
        log.warn("Get products");
        List<Product> products = new ArrayList<>();
        products.add(Product.builder()
                        .id(1)
                        .name("Ice cream")
                        .cost("100")
                .build());
        products.add(Product.builder()
                        .id(1)
                        .name("Pasta")
                        .cost("120")
                .build());
        return products;
    }
}