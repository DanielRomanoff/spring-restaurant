package ru.restaurant.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.restaurant.enums.Status;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "myschema", name = "order")
public class Order implements RestaurantEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Dish> dish;     // Список блюд

    @OneToOne(fetch = FetchType.EAGER)
    private Waiter waiter; // Официант

    private Double amount;       // Сумма

    private Status status;       // Статус заказа
}
