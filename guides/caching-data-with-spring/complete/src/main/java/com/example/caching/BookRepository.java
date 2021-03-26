package com.example.caching;

import org.springframework.cache.annotation.EnableCaching;


public interface BookRepository {
    Book getByIsbn(String isbn);
}
