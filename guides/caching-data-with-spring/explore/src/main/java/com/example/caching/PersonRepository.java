package com.example.caching;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    public Person save(Person person) {
        return person;
    }
    public Person findOne(Long id) {
        return new Person("RK", 33);
    }
}