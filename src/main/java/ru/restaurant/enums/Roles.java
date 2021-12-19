package ru.restaurant.enums;

public enum Roles {
    COOK("Повар"),
    ADMIN("Администратор"),
    WAITER("Официант");

    private final String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
