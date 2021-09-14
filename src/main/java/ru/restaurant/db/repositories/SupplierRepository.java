package ru.restaurant.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.restaurant.db.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
    List<Supplier> findAll();
}
