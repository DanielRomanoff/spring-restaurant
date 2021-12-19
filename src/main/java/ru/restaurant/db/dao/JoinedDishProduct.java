package ru.restaurant.db.dao;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(schema = "restaurant", name = "dishes_products")
public class JoinedDishProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", insertable = false, updatable = false)
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "number_of_products_for_dish")
    private Integer numberOfProductsForDish;

}