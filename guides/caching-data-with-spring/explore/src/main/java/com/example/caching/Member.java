package com.example.caching;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Member {
    private Integer id;
    private String name;
    private String location;
}
