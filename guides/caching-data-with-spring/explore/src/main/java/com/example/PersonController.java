package com.example;

import com.example.caching.Person;
import com.example.caching.PersonService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(@NonNull PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable Long id) {
        return personService.get(id);
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }
}