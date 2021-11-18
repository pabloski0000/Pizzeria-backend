package com.pizzeria.pizzeria.domain;

import reactor.core.publisher.Mono;

public interface Add<T> {
    public Mono<T> add(T data);
}
