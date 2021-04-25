package com.example.app.repository

import com.example.app.model.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository: CrudRepository<Person, Int>{
    // fun findNullableByName
    // fun findOneById
    fun findOneOrNoneById(id: Int): Person?
}