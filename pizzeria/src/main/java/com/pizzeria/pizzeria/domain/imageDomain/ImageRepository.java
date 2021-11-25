package com.pizzeria.pizzeria.domain.imageDomain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

public interface ImageRepository {
    Mono<Void> add(Image image);
    Mono<Image> findById(UUID id);
}
