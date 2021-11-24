package com.pizzeria.pizzeria.domain.userDomain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository  {
    Flux<User> getAll();
    Mono<User> add(User User);
    Mono<User> findById(UUID id);
    Flux<User> findByName(String name);
    Flux<User> findByEmail(String name);
    Mono<User> update(User User);
}
