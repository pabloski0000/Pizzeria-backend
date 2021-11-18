package com.pizzeria.pizzeria.domain.ingredient;

import java.util.UUID;

import com.pizzeria.pizzeria.application.ingredient.IngredientDtoIn;
import com.pizzeria.pizzeria.application.ingredient.IngredientDtoOut;

public class IngredientModelMapper {
    public static IngredientModel createModel(IngredientDtoIn ingredientDtoIn){
        IngredientModel ingredientModel = new IngredientModelImpl();
        ingredientModel.setId(UUID.randomUUID());
        ingredientModel.setName(ingredientDtoIn.getName());
        ingredientModel.setPrice(ingredientDtoIn.getPrice());
        return ingredientModel;
    }
    public static IngredientDtoOut createDto(IngredientModel ingredientModel) {
        IngredientDtoOut ingredientDtoOut = new IngredientDtoOut();
        ingredientDtoOut.setId(ingredientModel.getId());
        ingredientDtoOut.setName(ingredientModel.getName());
        ingredientDtoOut.setPrice(ingredientModel.getPrice());
        return ingredientDtoOut;
    }
}
