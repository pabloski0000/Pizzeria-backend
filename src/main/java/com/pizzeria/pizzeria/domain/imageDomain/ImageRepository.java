package com.pizzeria.pizzeria.domain.imageDomain;
import java.util.UUID;

import com.pizzeria.pizzeria.application.imageApplication.ImageDTO;

import reactor.core.publisher.Mono;

public interface ImageRepository {
    Mono <Image> findById(UUID id);
    Mono<ImageDTO> add(Image image);

}
