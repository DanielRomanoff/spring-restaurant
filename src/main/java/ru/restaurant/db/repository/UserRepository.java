package ru.restaurant.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.restaurant.db.dao.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    default User findByLogin(String login) {
        return this.findAll().stream()
                .filter(u -> u.getUsername().equals(login))
                .findFirst()
                .orElse(null);
    }
}
