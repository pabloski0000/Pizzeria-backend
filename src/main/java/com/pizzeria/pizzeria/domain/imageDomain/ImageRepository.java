package com.pizzeria.pizzeria.domain.imageDomain;
import java.util.UUID;
import reactor.core.publisher.Mono;

public interface ImageRepository {
    Mono<Image> get(byte[] image);
    Mono <Image> findById(UUID id);

}
