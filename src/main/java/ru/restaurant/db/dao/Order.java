package ru.restaurant.db.dao;

import lombok.*;
import ru.restaurant.enums.Status;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(schema = "restaurant", name = "orders")
public class Order implements RestaurantEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Dish> dish;     // Список блюд

    @Column(name = "amount")
    private Double amount;       // Сумма

    @Column(name = "status")
    private Status status;       // Статус заказа
}
