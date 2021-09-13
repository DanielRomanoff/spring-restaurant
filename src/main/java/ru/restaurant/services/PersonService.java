package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.db.Person;
import ru.restaurant.db.repositories.PersonRepository;
import ru.restaurant.db.repositories.ProductRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
