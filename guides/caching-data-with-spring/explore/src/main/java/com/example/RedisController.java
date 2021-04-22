package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @GetMapping()
    @Cacheable(value = "user2")
    public String get(@RequestParam String id) {
        logger.info("get user - userId: {}", id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @DeleteMapping()
    @CacheEvict(value = "user")
    public void delete(@RequestParam String id) {
        logger.info("delete user - userId:{}", id);
    }
}
