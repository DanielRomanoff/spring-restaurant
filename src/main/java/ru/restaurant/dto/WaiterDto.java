package ru.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Официант
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaiterDto implements Dto {
    private Integer id;
    private String name;
}