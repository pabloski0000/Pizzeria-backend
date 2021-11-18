package com.pizzeria.pizzeria.infrastructure.ingredient;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredient.IngredientModel;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngredientR2dbcRepository extends ReactiveCrudRepository<IngredientModel,UUID> {
    
}
