package com.example.caching;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    public PersonService(@NonNull PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // 메서드 항상 실행, 결과값에 id가 null이 아닌 경우 캐싱
    @CachePut(cacheNames = "person", key = "#person.id", unless = "#result.id != null")
    public Person save(Person person) {
        log.info("save() called");
        return personRepository.save(person);
    }

    // 캐시에 값이 없는 경우에는 로그를 남기고 repository 실행
    @Cacheable(cacheNames = "person")
    public Person get(@NonNull Long id) {
        log.info("get(Long) called");
        return personRepository.findOne(id);
    }
}