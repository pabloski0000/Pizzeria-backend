package com.pizzeria.pizzeria.application.ingredientApplication;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class IngredientDto {
    private UUID id;
    private String name;
    private BigDecimal price;
}
