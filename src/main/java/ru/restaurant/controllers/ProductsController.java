package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.dto.ProductDto;
import ru.restaurant.mappers.ProductMapper;
import ru.restaurant.services.ProductService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;
    private final ProductMapper mapper;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ProductDto> products() {
        log.info("Get products");
        return mapper.mapToDto(productService.getProducts());
    }

    @RequestMapping("/create")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ProductDto createProduct(@Valid @RequestBody ProductDto product) {
        log.info("Create product - {}", product);
        return mapper.mapToDto(productService.createProduct(mapper.mapToEntity(product)));
    }

    @RequestMapping("/add")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ProductDto addProductCount(ProductDto productDto, Integer count) {
        log.info("Add product {}, to count = {}", productDto, count);
        return mapper.mapToDto(productService.addProductCount(mapper.mapToEntity(productDto), count));
    }
}
