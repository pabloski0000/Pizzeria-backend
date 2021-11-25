package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserDto {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
}
