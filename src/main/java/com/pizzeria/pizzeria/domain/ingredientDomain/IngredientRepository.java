package com.pizzeria.pizzeria.domain.ingredientDomain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IngredientRepository  {
    Flux<Ingredient> getAll();
    Mono<Ingredient> add(Ingredient ingredient);
    Mono<Ingredient> findById(UUID id);
    Mono<Ingredient> update(Ingredient ingredient);
    Mono<Void> delete(Ingredient ingredient);
}
