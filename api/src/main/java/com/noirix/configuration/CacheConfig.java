package com.noirix.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Value("${cache.config.movies}")
    private String movies;
    @Value("${cache.config.sessions}")
    private String sessions;
    @Value("${cache.config.tickets}")
    private String tickets;
    @Value("${cache.config.initialCapacity}")
    private int initialCapacity;
    @Value("${cache.config.maximumSize}")
    private int maximumSize;
    @Value("${cache.config.duration}")
    private int duration;

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(movies, sessions, tickets);
        cacheManager.setCaffeine(cacheProperties());
        return cacheManager;
    }

    public Caffeine<Object, Object> cacheProperties() {
        return Caffeine.newBuilder()
                .initialCapacity(initialCapacity)
                .maximumSize(maximumSize)
                .expireAfterAccess(duration, TimeUnit.SECONDS)
                .weakKeys()
                .recordStats();
    }

}
