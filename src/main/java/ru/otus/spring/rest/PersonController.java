package ru.otus.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.domain.Person;
import ru.otus.spring.repostory.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(
            value = "/person",
            method = RequestMethod.GET
    )
    public List<PersonDto> get() {
        return repository.findAll().stream()
                .map(PersonDto::toDto)
                .collect(Collectors.toList());
    }
}
