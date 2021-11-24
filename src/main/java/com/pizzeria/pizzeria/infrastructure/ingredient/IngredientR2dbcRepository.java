package com.pizzeria.pizzeria.infrastructure.ingredient;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface IngredientR2dbcRepository extends ReactiveCrudRepository<Ingredient,UUID> {
    @Query("SELECT * FROM ingredients WHERE (name LIKE CONCAT('%', :name, '%')) ORDER BY name;")
    Flux<Ingredient> findByName(String name);
    @Query("SELECT * FROM ingredients WHERE (name LIKE :name) ORDER BY name;")
    Flux<Ingredient> findByExactName(String name);
}
