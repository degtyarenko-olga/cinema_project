package com.noirix.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    public static final String MOVIES = "movies";
    public static final String SESSIONS = "sessions";
    public static final String TICKETS = "tickets";
    public static final int INITIAL_CAPACITY = 10;
    public static final int MAXIMUM_SIZE = 100;
    public static final int DURATION = 10;

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(
                MOVIES, SESSIONS, TICKETS);
        cacheManager.setCaffeine(cacheProperties());
        return cacheManager;
    }

    public Caffeine<Object, Object> cacheProperties() {
        return Caffeine.newBuilder()
                .initialCapacity(INITIAL_CAPACITY)
                .maximumSize(MAXIMUM_SIZE)
                .expireAfterAccess(DURATION, TimeUnit.SECONDS)
                .weakKeys()
                .recordStats();
    }
}
