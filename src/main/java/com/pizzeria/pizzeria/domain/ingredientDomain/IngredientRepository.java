package com.pizzeria.pizzeria.domain.ingredientDomain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IngredientRepository  {
    Mono<Ingredient> add(Ingredient ingredient);
    Mono<Ingredient> findById(UUID id);
    Flux<Ingredient> findByName(String name);
    Flux<IngredientProjection> findByCriteria(String name, int size, int page);
    Mono<Void> update(Ingredient ingredient);
    Mono<Void> delete(Ingredient ingredient);
}
