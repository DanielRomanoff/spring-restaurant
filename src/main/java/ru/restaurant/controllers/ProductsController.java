package ru.restaurant.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @Operation(summary = "Получить все существующие продукты")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class))))})
    @RequestMapping(produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> products() {
        log.info("Get products");
        return ResponseEntity.ok(mapper.mapToDto(productService.getProducts()));
    }

    @Operation(summary = "Создать новый продукт")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Блюдо создано", content = @Content(schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "409", description = "Блюдо уже существует", content = @Content(schema = @Schema(implementation = String.class)))})
    @RequestMapping(value = "/create", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto product) {
        log.info("Create product - {}", product);
        return ResponseEntity.ok(mapper.mapToDto(productService.createProduct(mapper.mapToEntity(product))));
    }
}
