package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.restaurant.dto.DishDto;
import ru.restaurant.mappers.DishMapper;
import ru.restaurant.services.DishService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dish")
public class DishController {

    private final DishService dishService;
    private final DishMapper mapper;

    @RequestMapping("/create")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public DishDto createDish(DishDto dishDto) {
        log.info("create dish = {}", dishDto);
        return mapper.mapToDto(dishService.createDish(mapper.mapToEntity(dishDto)));
    }

    @RequestMapping("/update")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public DishDto updateDish(DishDto dishDto) {
        log.info("update dish = {}", dishDto);
        return mapper.mapToDto(dishService.updateDish(mapper.mapToEntity(dishDto)));
    }

    @RequestMapping("/delete")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public DishDto deleteDish(Integer id) {
        log.info("delete dish = {}", id);
        return mapper.mapToDto(dishService.deleteDish(id));
    }

    @RequestMapping("/menu")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public List<DishDto> updateDish(List<DishDto> dishDto) {
        log.info("update menu = {}", dishDto);
        return mapper.mapToDto(dishService.menu(mapper.mapToEntity(dishDto)));
    }
}
