package com.pizzeria.pizzeria.application.ingredient;

import java.util.UUID;

import com.pizzeria.pizzeria.application.Add;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientApplication {
    Flux<IngredientDto> getAll();
    Mono<IngredientDto> add(CreateOrUpdateIngredientDto createOrUpdateIngredientDto);
    Mono<IngredientDto> get(UUID id);
    Mono<IngredientDto> update(UUID id, CreateOrUpdateIngredientDto createOrUpdateIngredientDto);
    Mono<Void> delete(UUID id);
}
