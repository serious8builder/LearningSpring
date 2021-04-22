package com.example.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


import java.lang.reflect.Method;

@Configuration
public class RedisConfig {

    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                for (Object object: objects) {
                    sb.append(object.toString());
                }
                return sb.toString();
            }
        };
    }

    public LettuceConnectionFactory createLettuceConnectionFactory(int dbIndex, String host, int port, String password, int timeout) {
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
        connectionFactory.setDatabase(dbIndex);
        connectionFactory.setHostName(host);
        connectionFactory.setPort(port);
        connectionFactory.setPassword(password);
        connectionFactory.setTimeout(timeout);
        return connectionFactory;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        return redisCacheManager;
    }

    public void setSerializer(RedisTemplate redisTemplate) {
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //Setting the serialization of key s
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //The serialization of setting value s
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
    }
}
