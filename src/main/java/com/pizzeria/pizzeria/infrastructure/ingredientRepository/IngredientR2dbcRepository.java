package com.pizzeria.pizzeria.infrastructure.ingredientRepository;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;
import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientProjection;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface IngredientR2dbcRepository extends ReactiveCrudRepository<Ingredient,UUID> {
    @Query("SELECT id,name,price FROM ingredients WHERE (:name is NULL OR name LIKE CONCAT('%', :name, '%')) ORDER BY name limit :size offset :page;")
    Flux<IngredientProjection> findByCriteria(String name, int size, int page);
    @Query("SELECT name FROM ingredients WHERE name = :name;")
    Flux<Ingredient> findByName(String name);
}
