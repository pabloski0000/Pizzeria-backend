package com.pizzeria.pizzeria.controller.ingredient;

import com.pizzeria.pizzeria.application.ingredient.IngredientApplication;
import com.pizzeria.pizzeria.application.ingredient.IngredientDtoIn;
import com.pizzeria.pizzeria.application.ingredient.IngredientDtoOut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v2/ingredients")
public class IngredientController {
    private IngredientApplication ingredientApplication;
    @Autowired
    public IngredientController(IngredientApplication ingredientApplication){
        this.ingredientApplication = ingredientApplication;
    }
    @GetMapping("/hello")
    public String get() {
        return "Hello";
    }
    @PostMapping
    public Mono<IngredientDtoOut> create(@RequestBody IngredientDtoIn ingredientDtoIn) {
        return ingredientApplication.add(ingredientDtoIn);
    }
    
}
