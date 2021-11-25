package com.pizzeria.pizzeria.infrastructure.ingredientRepository;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngredientR2dbcRepository extends ReactiveCrudRepository<Ingredient,UUID> {
    
}
