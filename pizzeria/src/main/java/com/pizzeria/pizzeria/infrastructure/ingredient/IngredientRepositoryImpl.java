package com.pizzeria.pizzeria.infrastructure.ingredient;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredient.IngredientModel;
import com.pizzeria.pizzeria.domain.ingredient.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    @Autowired
    private final IngredientR2dbcRepository ingredientR2dbcRepository;
    @Autowired
    public IngredientRepositoryImpl(final IngredientR2dbcRepository ingredientR2dbcRepository){
        this.ingredientR2dbcRepository = ingredientR2dbcRepository;
    }
    @Override
    public Mono<IngredientModel> add(IngredientModel ingredientModel) {
        return ingredientR2dbcRepository.save(ingredientModel);
    }
    
}
