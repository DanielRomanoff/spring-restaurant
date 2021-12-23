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
import ru.restaurant.dto.OrderDto;
import ru.restaurant.mappers.OrderMapper;
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
    private final OrderMapper mapper;

    @Operation(summary = "Получить все существующие заказы")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderDto.class))))})
    @RequestMapping(produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> orders() {
        log.info("Get orders");
        return ResponseEntity.ok(mapper.mapToDto(orderService.getOrders()));
    }

    @Operation(summary = "Создать новое блюдо")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Блюдо создано", content = @Content(schema = @Schema(implementation = OrderDto.class))),
            @ApiResponse(responseCode = "409", description = "Блюдо уже существует", content = @Content(schema = @Schema(implementation = String.class)))})
    @RequestMapping(value = "/create", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
        log.info("Create order = {}", orderDto);
        return ResponseEntity.ok(mapper.mapToDto(orderService.createOrder(mapper.mapToEntity(orderDto))));
    }

    @Operation(summary = "Получить общую сумму выручки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderDto.class))))})
    @RequestMapping(value = "/amount", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Double> getAmountByOrders() {
        log.info("Get amount");
        return ResponseEntity.ok(orderService.getAmount());
    }

    @Operation(summary = "Обновить статус заказа")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Заказ не найден")})
    @RequestMapping(value = "/status", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public void changeOrderStatus(@RequestBody OrderDto orderDto) {
        log.info("Change status = {}", orderDto);
        orderService.changeOrderStatus(mapper.mapToEntity(orderDto));
    }
}
