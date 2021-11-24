package com.pizzeria.pizzeria.infrastructure.userRepository;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.userDomain.UserRepository;
import com.pizzeria.pizzeria.domain.userDomain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserR2dbcRepositoryImpl implements UserRepository {
    private UserR2dbcRepository userR2dbcRepository;
    @Autowired
    public UserR2dbcRepositoryImpl(final UserR2dbcRepository userR2dbcRepository){
        this.userR2dbcRepository = userR2dbcRepository;
    }
    @Override
    public Mono<User> add(User user) {
        return userR2dbcRepository.save(user);
    }
    @Override
    public Mono<User> findById(UUID id) {
        return userR2dbcRepository.findById(id);
    }
    @Override
    public Mono<User> update(User user) {
        return userR2dbcRepository.save(user);
    }
    @Override
    public Flux<User> getAll() {
        return userR2dbcRepository.findAll();
    }
    @Override
    public Flux<User> findByName(String name) {
        return userR2dbcRepository.findByName(name);
    }
    @Override
    public Flux<User> findByEmail(String email) {
        return userR2dbcRepository.findByEmail(email);
    }
}
