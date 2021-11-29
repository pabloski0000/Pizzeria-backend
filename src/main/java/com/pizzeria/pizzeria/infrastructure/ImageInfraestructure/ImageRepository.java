package com.pizzeria.pizzeria.infrastructure.ImageInfraestructure;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends ReactiveRedisOperations<String, byte[]>{
    
}
