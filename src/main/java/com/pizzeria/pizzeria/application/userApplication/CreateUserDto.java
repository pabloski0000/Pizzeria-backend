package com.pizzeria.pizzeria.application.userApplication;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public @Getter @Setter class CreateUserDto {
    @NotBlank
    @Size(max = 15)
    private String name;
    @NotBlank
    @Size(max = 15)
    private String lastName;
    @NotBlank
    @Size(max = 16)
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String token;
}