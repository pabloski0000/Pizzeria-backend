package com.pizzeria.pizzeria.application.ingredientApplication;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public @Getter @Setter class CreateOrUpdateIngredientDto {
    @NotBlank(message = "The name of the ingredient must include at least one letter")
    @Size(max = 45, message = "The name must have a size between 1 and 45 characters")
    private String name;
    @NotNull
    @Digits(integer = 3, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
}
