package com.pizzeria.pizzeria.application.userApplication;
import java.util.UUID;

import com.pizzeria.pizzeria.core.ApplicationBase;
import com.pizzeria.pizzeria.core.exceptions.BadRequestException;
import com.pizzeria.pizzeria.domain.userDomain.User;
import com.pizzeria.pizzeria.domain.userDomain.UserProjection;
import com.pizzeria.pizzeria.domain.userDomain.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserApplicationImpl extends ApplicationBase<User, UUID> implements UserApplication {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Autowired
    public UserApplicationImpl(UserRepository userRepository, ModelMapper modelMapper){
        super(userRepository::findById);
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Mono<UserDto> add(CreateOrUpdateUserDto createOrUpdateUserDto) {
        User user = modelMapper.map(createOrUpdateUserDto, User.class);
        user.setId(UUID.randomUUID());
        user.setThisNew(true);
        return user
            .<String, User>validate(userRepository::findByEmail, user.getEmail())
            .then(
                userRepository.add(user)
                .map(createdUser -> modelMapper.map(createdUser, UserDto.class))
            );
    }
    @Override
    public Mono<UserDto> get(UUID id) {
        return findById(id)
            .map(User -> modelMapper.map(User, UserDto.class));
    }
    @Override
    public Mono<Void> update(UUID id, CreateOrUpdateUserDto createOrUpdateUserDto) {
        User user = modelMapper.map(createOrUpdateUserDto, User.class);
        user.setId(id);
        return findById(id)
            .then(
                userRepository.update(user)
            );
    }
    /*@Override
    public Flux<UserProjection> getByCriteria(String name, int size, int page) {
        return UserRepository.findByCriteria(name, size, page);
    }*/
}
