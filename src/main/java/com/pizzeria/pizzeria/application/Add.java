package com.pizzeria.pizzeria.application;
import reactor.core.publisher.Mono;
public class Add <T,R>{
    public Mono<R> add(T dto);
}
