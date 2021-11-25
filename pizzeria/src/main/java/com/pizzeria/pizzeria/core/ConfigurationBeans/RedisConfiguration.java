package com.pizzeria.pizzeria.core.ConfigurationBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {
    @Bean
    public ReactiveRedisTemplate<String, byte[]> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        ByteSerializer byteSerializer = new ByteSerializer();
        RedisSerializationContext.RedisSerializationContextBuilder<String, byte[]> builder = RedisSerializationContext.newSerializationContext(keySerializer);
        RedisSerializationContext<String, byte[]> context = builder.value(byteSerializer).build();
        return new ReactiveRedisTemplate<>(factory, context);
    }
}
