package com.pizzeria.pizzeria.application.ingredient;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;
import com.pizzeria.pizzeria.domain.ingredientDomain.IngredientRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IngredientApplicationImpl implements IngredientApplication {
    private IngredientRepository ingredientRepository;
    private ModelMapper modelMapper;
    @Autowired
    public IngredientApplicationImpl(IngredientRepository ingredientRepository, ModelMapper modelMapper){
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Mono<IngredientDto> add(CreateOrUpdateIngredientDto createOrUpdateIngredientDto) {
        Ingredient ingredient = modelMapper.map(createOrUpdateIngredientDto, Ingredient.class);
        ingredient.setId(UUID.fromString(createOrUpdateIngredientDto.getName()));
        ingredient.setThisNew(true);
        return ingredientRepository.add(ingredient)
            .switchIfEmpty(Mono.error(new Exception("Ingredient wasn't saved correctly in the database: " + createOrUpdateIngredientDto)))
            .map(createdIngredient -> modelMapper.map(createdIngredient, IngredientDto.class));
        /*return ingredientRepository.add(ingredient)
        .flatMap(foundIngredient -> Mono.just(modelMapper.map(foundIngredient, IngredientDto.class)));*/
    }
    @Override
    public Mono<IngredientDto> get(UUID id) {
        return ingredientRepository.findById(id)
            .switchIfEmpty(Mono.error(new NotFoundException("There isn't any ingredient with the id: " + id)))
            .map(ingredient -> modelMapper.map(ingredient, IngredientDto.class));
    }
    @Override
    public Mono<IngredientDto> update(UUID id, CreateOrUpdateIngredientDto createOrUpdateIngredientDto) {
        Ingredient ingredient = modelMapper.map(createOrUpdateIngredientDto, Ingredient.class);
        ingredient.setId(id);
        return ingredientRepository.update(ingredient)
            .switchIfEmpty(Mono.error(new NotFoundException("There isn't any ingredient with the id: " + id)))
            .map(foundIngredient -> modelMapper.map(foundIngredient, IngredientDto.class));
    }
    @Override
    public Flux<IngredientDto> getAll() {
        return ingredientRepository.getAll().map(foundIngredient -> modelMapper.map(foundIngredient, IngredientDto.class));
    }
    @Override
    public Mono<Void> delete(UUID id) {
        return ingredientRepository.findById(id)
            .switchIfEmpty(Mono.error(new NotFoundException("There isn't any ingredient with the id: " + id)))
            .flatMap(ingredientRepository::delete);
    }
    
}
