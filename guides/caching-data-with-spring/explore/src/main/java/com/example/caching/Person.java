package com.example.caching;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class Person {
    private Long id;
    private String name;
    private Integer age;

    public Person(@NonNull String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @JsonCreator
    public Person(@JsonProperty("id") Long id,
                  @JsonProperty("name") String name,
                  @JsonProperty("age") int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
