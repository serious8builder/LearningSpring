package com.example.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;


@Component
public class SimpleBookRepository implements BookRepository {

    private static Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        logger.info("Method getByIsbn called: " + isbn);
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
