package com.pizzeria.pizzeria.infrastructure.imageRepository;

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
    public Mono<Void> add(Image image) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Mono<Image> findById(UUID id) {
        return imageReactiveRedisRepository.opsForValue().get(id)
            .map(contentImage -> {
                Image image = new Image();
                image.setId(id);
                image.setContent(contentImage);
                return image;
            });
    }
    
}
