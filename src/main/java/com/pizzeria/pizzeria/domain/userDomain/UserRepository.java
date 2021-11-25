package com.pizzeria.pizzeria.domain.userDomain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> add(User user);
    Mono<User> findById(UUID id);
    Flux<User> findByName(String name);
    Flux<User> findByEmail(String email);
    //Flux<UserProjection> findByCriteria(String name, int size, int page);
    Mono<Void> update(User User);
}
