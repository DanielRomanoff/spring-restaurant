package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.db.Order;
import ru.restaurant.db.Person;
import ru.restaurant.services.PersonService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Person> persons() {
        log.info("Get persons");
        return personService.getPersons();
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Person createPerson(@Valid @RequestBody Person person) {
        log.info("Create person = {}", person);
        return personService.createPerson(person);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE)
    public void deletePerson(@RequestBody Person person) {
        log.info("Delete person = {}", person);
        personService.deletePerson(person);
    }
}
