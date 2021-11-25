package com.pizzeria.pizzeria.application.ingredientApplication;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientProjection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientApplication {
    Flux<IngredientProjection> getByCriteria(String name, int size, int page);
    Mono<IngredientDto> add(CreateOrUpdateIngredientDto createOrUpdateIngredientDto);
    Mono<IngredientDto> get(UUID id);
    Mono<Void> update(UUID id, CreateOrUpdateIngredientDto createOrUpdateIngredientDto);
    Mono<Void> delete(UUID id);
}
