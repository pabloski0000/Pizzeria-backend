package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.userDomain.UserProjection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserApplication {
    Mono<UserOutDto> add(CreateUserDto createUserDto);
    Mono<UserDto> get(UUID id);
    Mono<Void> update(UUID id, CreateUserDto createUserDto);
}