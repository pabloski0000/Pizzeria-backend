package com.pizzeria.pizzeria.core;

import com.pizzeria.pizzeria.core.exceptions.NotFoundException;
import com.pizzeria.pizzeria.core.functionalInterfaces.FindById;

import reactor.core.publisher.Mono;

public class ApplicationBase<T, ID> {
    private FindById<T, ID> getById;
    protected ApplicationBase(FindById<T, ID> getById){
        this.getById = getById;
    }
    protected Mono<T> findById(ID id){
        return this.getById.findById(id).switchIfEmpty(Mono.error(new NotFoundException("There isn't any ingredient with the id: " + id)));
    }
    protected String serializeObject(T entity, String message) {

        return String.format("%s %s succesfully.", entity.toString(), message);
    }
}
