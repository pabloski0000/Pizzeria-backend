package com.pizzeria.pizzeria.application.userApplication;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.pizzeria.pizzeria.domain.userDomain.Rol;

import org.springframework.validation.annotation.Validated;

@Validated
public @Getter @Setter class CreateOrUpdateUserDto {
    @NotBlank(message = "The name must include at least one letter")
    @Size(max = 15, message = "The name must have a size between 1 and 15 characters")
    private String name;
    @NotBlank(message = "The last name must include at least one letter")
    @Size(max = 15, message = "The name must have a size between 1 and 15 characters")
    private String lastName;
    @NotBlank(message = "The email must include at least one letter")
    private String email;
    @NotBlank(message = "The password must include at least one letter")
    private String password;
    private Rol rol = Rol.USER;
}
