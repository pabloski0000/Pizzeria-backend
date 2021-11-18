package com.pizzeria.pizzeria.application.ingredient;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class IngredientDtoOut {
    private UUID id;
    private String name;
    private BigDecimal price;
}
