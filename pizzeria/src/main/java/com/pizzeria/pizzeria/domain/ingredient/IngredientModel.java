package com.pizzeria.pizzeria.domain.ingredient;

import java.math.BigDecimal;
import java.util.UUID;

public interface IngredientModel {
    public UUID getId();
    public void setId(UUID id);
    public String getName();
    public void setName(String name);
    public BigDecimal getPrice();
    public void setPrice(BigDecimal price);
}
