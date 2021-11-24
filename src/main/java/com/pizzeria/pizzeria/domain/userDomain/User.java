package com.pizzeria.pizzeria.domain.userDomain;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.pizzeria.pizzeria.core.EntityBase;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("users")
public @Getter @Setter class User extends EntityBase {
    @Column
    @NotBlank
    @Size(max = 15, message = "The name must have a size between 1 and 15 characters")
    private String name;
    @Column
    @NotBlank
    @Size(max = 15, message = "The name must have a size between 1 and 15 characters")
    private String lastName;
    @Column
    @NotBlank
    private String email;
    @Column
    @NotBlank
    private String password;
    @Column
    private Rol rol = Rol.USER;
}
