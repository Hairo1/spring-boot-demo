package com.hairo.springbootcache.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.Ticker;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author Hairo
 * @date 2020/7/7 10:50
 */
@Configuration
public class CacheManagerConfig {
    @Bean
    public CacheManager cacheManager(Ticker ticker) {
        CaffeineCache messageCache = buildCache("users", ticker, 10);
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Arrays.asList(messageCache));
        return manager;
    }

    private CaffeineCache buildCache(String name, Ticker ticker, int minutesToExpire) {
        return new CaffeineCache(name, Caffeine.newBuilder()
                .expireAfterAccess(minutesToExpire, TimeUnit.SECONDS)
                .maximumSize(100)
                .ticker(ticker)
                .removalListener((Object key, Object value, RemovalCause cause) -> {
                    System.out.println("key->"+key.toString());
                    System.out.println("value->"+value);
                    System.out.println("cause->"+cause.name());
                })
                .build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }
}
