package com.pizzeria.pizzeria.infrastructure.imageRepository;

import java.time.Duration;
import java.util.UUID;

import com.pizzeria.pizzeria.domain.imageDomain.Image;
import com.pizzeria.pizzeria.domain.imageDomain.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public class ImageRepositoryImpl implements ImageRepository {
    private ReactiveRedisOperations<String, byte[]> imageReactiveRedisRepository;
    @Autowired
    public ImageRepositoryImpl(final ReactiveRedisOperations<String, byte[]> imageReactiveRedisRepository){
        this.imageReactiveRedisRepository = imageReactiveRedisRepository;
    }
    @Override
    public Mono<Boolean> add(Image image) {
        return imageReactiveRedisRepository
            .opsForValue()
            .set(image.getId().toString(), image.getContent(), Duration.ofDays(1));
    }
    @Override
    public Mono<byte[]> findById(UUID id) {
        return imageReactiveRedisRepository.opsForValue().get(id.toString());
    }
    
}
