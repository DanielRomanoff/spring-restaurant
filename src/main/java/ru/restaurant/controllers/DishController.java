package ru.restaurant.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.dto.DishDto;
import ru.restaurant.mappers.DishMapper;
import ru.restaurant.services.DishService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dish")
public class DishController {

    private final DishService dishService;
    private final DishMapper mapper;

    @Operation(summary = "Получить все существующие блюда")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(array = @ArraySchema(schema = @Schema(implementation = DishDto.class))))})
    @RequestMapping(produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<DishDto>> dishes() {
        log.info("get dishes");
        return ResponseEntity.ok(mapper.mapToDto(dishService.getDishes()));
    }

    @Operation(summary = "Создать новое блюдо")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Блюдо создано", content = @Content(schema = @Schema(implementation = DishDto.class))),
            @ApiResponse(responseCode = "409", description = "Блюдо уже существует", content = @Content(schema = @Schema(implementation = String.class)))})
    @RequestMapping(value = "/create", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<DishDto> createDish(@Valid @RequestBody DishDto dishDto) {
        log.info("create dish = {}", dishDto);
        return ResponseEntity.ok(mapper.mapToDto(dishService.createDish(mapper.mapToEntity(dishDto))));
    }

    @Operation(summary = "Обновить существующее блюдо")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Блюдо не найдено")})
    @RequestMapping(value = "/update", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<DishDto> updateDish(@Valid @RequestBody DishDto dishDto) {
        log.info("update dish = {}", dishDto);
        return ResponseEntity.ok(mapper.mapToDto(dishService.updateDish(mapper.mapToEntity(dishDto))));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Блюдо удалено", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DishDto.class))}),
            @ApiResponse(responseCode = "404", description = "Блюдо не найдено", content = @Content)})
    @Operation(summary = "Удалить блюдо")
    @RequestMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDish(@PathVariable(value = "id") Integer id) {
        log.info("delete dish = {}", id);
        dishService.deleteDish(id);
    }

    @Operation(summary = "Добавить в меню список блюд")
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DishDto>> createMenu(@Valid @RequestBody List<DishDto> dishDto) {
        log.info("update menu = {}", dishDto);
        return ResponseEntity.ok(mapper.mapToDto(dishService.menu(mapper.mapToEntity(dishDto))));
    }
}
