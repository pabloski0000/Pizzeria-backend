package com.pizzeria.pizzeria.domain.ingredientDomain;

import java.math.BigDecimal;

import com.pizzeria.pizzeria.core.EntityBase;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("ingredients")
public @Getter @Setter class Ingredient extends EntityBase {
    @Column
    private String name;
    @Column
    private BigDecimal price;
}
