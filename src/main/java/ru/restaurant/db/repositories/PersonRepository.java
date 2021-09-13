package ru.restaurant.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.restaurant.db.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findAll();
}
