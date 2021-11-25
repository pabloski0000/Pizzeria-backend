package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserApplication {
    //Flux<IngredientProjection> getByCriteria(String name, int size, int page);
    Mono<UserDto> add(CreateOrUpdateUserDto createOrUpdateUserDto);
    Mono<UserDto> get(UUID id);
    Mono<Void> update(UUID id, CreateOrUpdateUserDto createOrUpdateUserDto);
}