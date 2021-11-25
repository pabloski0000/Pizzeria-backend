package com.pizzeria.pizzeria.infrastructure.ingredientRepository;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;
import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientProjection;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface IngredientR2dbcRepository extends ReactiveCrudRepository<Ingredient,UUID> {
    @Query("SELECT * FROM ingredients WHERE (:name is NULL OR name LIKE CONCAT('%', :name, '%')) ORDER BY name limit :size offset :page;")
    Flux<IngredientProjection> findByCriteria(String name, int size, int page);
    @Query("SELECT * FROM ingredients WHERE (name LIKE CONCAT('%', :name, '%')) ORDER BY name;")
    Flux<Ingredient> findByName(String name);
    @Query("SELECT * FROM ingredients WHERE (name LIKE :name) ORDER BY name;")
    Flux<Ingredient> findByExactName(String name);
}
