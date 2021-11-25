package com.pizzeria.pizzeria.infrastructure.imageRepository;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageReactiveRedisRepository extends ReactiveRedisOperations<String, byte[]> {
    
}
