package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;

//import com.pizzeria.pizzeria.application.Add;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserApplication {
    Flux<UserDTO> getAll();
    Mono<UserDTO> add(CreateOrUpdateUserDto createOrUpdateUserDto);
    Mono<UserDTO> get(UUID id);
    Mono<UserDTO> update(UUID id, CreateOrUpdateUserDto createOrUpdateUserDto);
}
