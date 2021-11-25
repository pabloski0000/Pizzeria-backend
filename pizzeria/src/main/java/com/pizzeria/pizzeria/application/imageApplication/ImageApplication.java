package com.pizzeria.pizzeria.application.imageApplication;

import java.util.UUID;

import reactor.core.publisher.Mono;

public interface ImageApplication {
    Mono<ImageDto> findById(UUID id);
}
