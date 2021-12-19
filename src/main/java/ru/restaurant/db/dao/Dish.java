package ru.restaurant.db.dao;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(schema = "restaurant", name = "dishes")
public class Dish implements RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(max = 45)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "cost")
    private String cost;

    @OneToMany
    private List<Product> products;

    @Column(name = "in_menu")
    private Boolean menu;

    @Transient
    private Map<Integer, Integer> productCountMap;
}
