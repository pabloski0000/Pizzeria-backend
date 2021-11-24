package com.pizzeria.pizzeria.domain.ingredientDomain;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.math.BigDecimal;

import com.pizzeria.pizzeria.core.EntityBase;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("ingredients")
public @Getter @Setter class Ingredient extends EntityBase {
    @Column
    @NotBlank
    @Size(max = 45, message = "The name must have a size between 1 and 45 characters")
    private String name;
    @Column
    @NotNull
    @Digits(integer = 3, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
}
