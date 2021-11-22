package com.pizzeria.pizzeria.infrastructure.ingredient;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;
import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javassist.NotFoundException;
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
    public Mono<Ingredient> update(Ingredient ingredient) {
        return ingredientR2dbcRepository.save(ingredient);
    }
    @Override
    public Flux<Ingredient> getAll() {
        return ingredientR2dbcRepository.findAll();
    }
    @Override
    public Mono<Void> delete(Ingredient ingredient) {
        return ingredientR2dbcRepository.delete(ingredient);
    }
    public Mono<Void> doSomething(UUID id) {
        return ingredientR2dbcRepository.findById(id).flatMap(foundIngredient -> Mono.error(new NotFoundException("Cara culo: " + foundIngredient)));
    }
}
