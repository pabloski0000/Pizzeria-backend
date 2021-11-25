package com.pizzeria.pizzeria.application.ingredientApplication;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class CreateOrUpdateIngredientDto {
    private String name;
    private BigDecimal price;
}
