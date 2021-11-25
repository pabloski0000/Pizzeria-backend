package com.pizzeria.pizzeria.controller.ingredientController;

import java.util.UUID;

import com.pizzeria.pizzeria.application.ingredientApplication.CreateOrUpdateIngredientDto;
import com.pizzeria.pizzeria.application.ingredientApplication.IngredientApplication;
import com.pizzeria.pizzeria.application.ingredientApplication.IngredientDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/v2/ingredients")
public class IngredientController {
    private final IngredientApplication ingredientApplication;
    @Autowired
    public IngredientController(final IngredientApplication ingredientApplication){
        this.ingredientApplication = ingredientApplication;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<IngredientDto> show() {
        return ingredientApplication.getAll();
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Mono<IngredientDto> read(@PathVariable UUID id) {
        return ingredientApplication.get(id);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<IngredientDto> create(@RequestBody CreateOrUpdateIngredientDto ingredientDtoIn) {
        return ingredientApplication.add(ingredientDtoIn);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Mono<IngredientDto> create(@PathVariable UUID id, @RequestBody CreateOrUpdateIngredientDto ingredientDtoIn) {
        return ingredientApplication.update(id, ingredientDtoIn);
    }
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Mono<Void> create(@PathVariable UUID id) {
        return ingredientApplication.delete(id);
    }
}
