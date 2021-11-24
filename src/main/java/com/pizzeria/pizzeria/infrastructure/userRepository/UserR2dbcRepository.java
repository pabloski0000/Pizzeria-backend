package com.pizzeria.pizzeria.infrastructure.userRepository;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.userDomain.User;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface UserR2dbcRepository extends ReactiveCrudRepository<User, UUID> {
    @Query("SELECT * FROM users WHERE (name LIKE CONCAT('%', :name, '%')) ORDER BY name;")
    Flux<User> findByName(String name);
    @Query("SELECT * FROM users WHERE (email LIKE :email) ORDER BY email;")
    Flux<User> findByEmail(String email);
}
