package com.example.app.config

import com.datastax.oss.driver.api.core.CqlSession
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun session(): CqlSession {
        return CqlSession.builder().withKeyspace("mks").build();
    }
}