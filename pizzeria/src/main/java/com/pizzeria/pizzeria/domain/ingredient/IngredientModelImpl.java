package com.pizzeria.pizzeria.domain.ingredient;

import java.math.BigDecimal;

import javax.persistence.Entity;

import com.pizzeria.pizzeria.core.EntityBase;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table("ingredients")
public @Getter @Setter class IngredientModelImpl extends EntityBase implements IngredientModel {
    private String name;
    private BigDecimal price;
    
}
