package com.example.caching;

import org.springframework.stereotype.Component;

public interface MemberRepository {
    public Member getById(Integer id);
    public Member changeLocation(Integer id, String location);
}
