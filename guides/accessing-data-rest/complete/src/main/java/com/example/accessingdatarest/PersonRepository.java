package com.example.accessingdatarest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people") // 복수 단어와 path 를 설정
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);
}
