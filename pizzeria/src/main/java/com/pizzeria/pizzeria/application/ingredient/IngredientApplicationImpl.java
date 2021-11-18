package com.pizzeria.pizzeria.application.ingredient;

import com.pizzeria.pizzeria.domain.ingredient.IngredientModel;
import com.pizzeria.pizzeria.domain.ingredient.IngredientModelMapper;
import com.pizzeria.pizzeria.domain.ingredient.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class IngredientApplicationImpl implements IngredientApplication {
    private IngredientRepository ingredientRepository;
    @Autowired
    public IngredientApplicationImpl(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    @Override
    public Mono<IngredientDtoOut> add(IngredientDtoIn ingredientDtoIn) {
        IngredientModel ingredientModel = IngredientModelMapper.createModel(ingredientDtoIn);
        return ingredientRepository.add(ingredientModel)
            .switchIfEmpty(Mono.error(new Exception("Ingredient wasn't saved correctly in the database: " + ingredientDtoIn)))
            .map(IngredientModelMapper::createDto);
    }
    
}
