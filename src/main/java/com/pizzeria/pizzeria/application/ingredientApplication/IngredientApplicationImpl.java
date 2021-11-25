package com.pizzeria.pizzeria.application.ingredientApplication;

import java.util.UUID;

import com.pizzeria.pizzeria.core.ApplicationBase;
import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;
import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientProjection;
import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IngredientApplicationImpl extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {
    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public IngredientApplicationImpl(final IngredientRepository ingredientRepository, final ModelMapper modelMapper){
        super(ingredientRepository::findById);
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Mono<IngredientDto> add(CreateOrUpdateIngredientDto createOrUpdateIngredientDto) {
        Ingredient ingredient = modelMapper.map(createOrUpdateIngredientDto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.setThisNew(true);
      
        return ingredient
            .<String, Ingredient>validate(ingredientRepository::findByName, ingredient.getName())
            .then(
                ingredientRepository.add(ingredient)
                .map(createdIngredient -> modelMapper.map(createdIngredient, IngredientDto.class))
            );
        
    }
    @Override
    public Mono<IngredientDto> get(UUID id) {
        return findById(id)
            .map(ingredient -> modelMapper.map(ingredient, IngredientDto.class));
    }
    @Override
    public Mono<Void> update(UUID id, CreateOrUpdateIngredientDto createOrUpdateIngredientDto) {
        Ingredient ingredient = modelMapper.map(createOrUpdateIngredientDto, Ingredient.class);
        ingredient.setId(id);
        return findById(id)
            .then(
                ingredientRepository.update(ingredient)
            );
    }
    @Override
    public Flux<IngredientProjection> getByCriteria(String name, int size, int page) {
        return ingredientRepository.findByCriteria(name, size, page);
    }
    @Override
    public Mono<Void> delete(UUID id) {
        return findById(id).flatMap(ingredientRepository::delete);
    }
    
}
