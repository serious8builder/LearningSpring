package com.example.app.runner

import com.datastax.oss.driver.api.core.CqlSession
import com.example.app.model.Person
import com.example.app.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.data.cassandra.core.query.Criteria
import org.springframework.data.cassandra.core.query.Query
import org.springframework.stereotype.Component





@Component
class CassandraRunner: CommandLineRunner {

    @Autowired
    lateinit var session: CqlSession

    @Autowired
    lateinit var personRepository: PersonRepository

    override fun run(vararg args: String?){
        println("--------- Cassandra Runner --------")

        val cqlSession: CqlSession = CqlSession.builder().withKeyspace("mks").build()
        val template: CassandraTemplate = CassandraTemplate(session)
        var person = template.selectOne("SELECT id, name FROM person WHERE id = 1", Person::class.java)
        println(person)

        template.insert(Person(2,"MJ"))
        person = template.selectOne(Query.query(Criteria.where("id").`is`(2)), Person::class.java)
        println(person)

        val person2 = personRepository.findOneOrNoneById(1)
        println(person2)

    }
}