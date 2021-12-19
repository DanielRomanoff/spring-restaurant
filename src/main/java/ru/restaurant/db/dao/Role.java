package ru.restaurant.db.dao;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(schema = "restaurant", name = "roles")
public class Role implements RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}

//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvYmxpdmlvbmJ1biIsInJvbGVzIjpbIkFETUlOIl0sImlhdCI6MTYzNjMwNzgwMCwiZXhwIjoxNjM2MzExNDAwfQ.BvkiNJEQtdA3QkmM0qo59-tOi-j4BpyHejpi206yYdI