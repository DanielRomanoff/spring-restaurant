package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.db.Person;
import ru.restaurant.db.Product;
import ru.restaurant.services.ProductService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Product> products() {
        log.info("Get products");
        return productService.getProducts();
    }

    @PostMapping(value = "/create", produces = APPLICATION_JSON_VALUE)
    public Product createProduct(@Valid @RequestBody Product product) {
        log.warn("Create product - {}", product);
        return productService.createProduct(product);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE)
    public void deleteProduct(@RequestBody Product product) {
        log.info("Delete person = {}", product);
        productService.deleteProduct(product);
    }
}
