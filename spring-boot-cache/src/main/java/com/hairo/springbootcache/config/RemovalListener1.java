package com.hairo.springbootcache.config;

import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author Hairo
 * @date 2020/7/7 10:57
 */
public class RemovalListener1 implements RemovalListener {
    @Override
    public void onRemoval(@Nullable Object key, @Nullable Object value, @NonNull RemovalCause cause) {
        System.out.println("key->"+key);
        System.out.println("value->"+value);
        System.out.println("cause->"+cause);
    }
}
