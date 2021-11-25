package com.pizzeria.pizzeria.domain.imageDomain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

public interface ImageRepository {
    Mono<Boolean> add(Image image);
    Mono<byte[]> findById(UUID id);
}
