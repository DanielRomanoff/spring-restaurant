package ru.restaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    CREATED("Создан"),
    IN_PROGRESS("Готовится"),
    READY("Готов"),
    PAYED("Оплачен");

    private final String name;
}
