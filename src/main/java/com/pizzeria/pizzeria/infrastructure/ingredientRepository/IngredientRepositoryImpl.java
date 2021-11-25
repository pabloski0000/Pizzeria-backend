package com.pizzeria.pizzeria.infrastructure.ingredientRepository;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;
import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientProjection;
import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    private IngredientR2dbcRepository ingredientR2dbcRepository;
    @Autowired
    public IngredientRepositoryImpl(final IngredientR2dbcRepository ingredientR2dbcRepository){
        this.ingredientR2dbcRepository = ingredientR2dbcRepository;
    }
    @Override
    public Mono<Ingredient> add(Ingredient ingredient) {
        return ingredientR2dbcRepository.save(ingredient);
    }
    @Override
    public Mono<Ingredient> findById(UUID id) {
        return ingredientR2dbcRepository.findById(id);
    }
    @Override
    public Mono<Void> update(Ingredient ingredient) {
        return ingredientR2dbcRepository.save(ingredient).then();
    }
    @Override
    public Mono<Void> delete(Ingredient ingredient) {
        return ingredientR2dbcRepository.delete(ingredient);
    }
    @Override
    public Flux<Ingredient> findByName(String name) {
        return ingredientR2dbcRepository.findByName(name);
    }
    @Override
    public Flux<IngredientProjection> findByCriteria(String name, int size, int page) {
        return ingredientR2dbcRepository.findByCriteria(name, size, page);
    }
}
