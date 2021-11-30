package com.pizzeria.pizzeria.controller.userController;

import java.util.UUID;

import javax.validation.Valid;

import com.pizzeria.pizzeria.application.userApplication.CreateUserDto;
import com.pizzeria.pizzeria.application.userApplication.UserApplication;
import com.pizzeria.pizzeria.application.userApplication.UserDto;
import com.pizzeria.pizzeria.application.userApplication.UserOutDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/v2/users")
public class UserController {
    private final UserApplication userApplication;

    @Autowired
    public UserController(final UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Mono<UserDto> read(@PathVariable UUID id) {
        return userApplication.get(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserOutDto> create(@Valid @RequestBody CreateUserDto createUserDto) {
        return this.userApplication.add(createUserDto);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> update(@PathVariable UUID id, @RequestBody CreateUserDto UserDtoIn) {
        return userApplication.update(id, UserDtoIn);
    }
}
