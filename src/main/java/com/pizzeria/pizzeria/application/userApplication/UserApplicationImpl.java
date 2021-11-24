package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;

import com.pizzeria.pizzeria.core.ApplicationBase;
//import com.pizzeria.pizzeria.core.exceptions.BadRequestException;
import com.pizzeria.pizzeria.domain.userDomain.UserRepository;
import com.pizzeria.pizzeria.domain.userDomain.User;
//import com.pizzeria.pizzeria.application.userApplication.CreateOrUpdateUserDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javassist.NotFoundException;
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
    public Mono<UserDTO> add(CreateOrUpdateUserDto createOrUpdateuserDto) {
        User user = modelMapper.map(createOrUpdateuserDto, User.class);
        user.setId(UUID.randomUUID());
        user.setThisNew(true);
        return user
            .<String, User>validate(userRepository::findByEmail, user.getName())
            .then(
                userRepository.add(user)
                .map(createduser -> modelMapper.map(createduser, UserDTO.class))
            );
    }
    @Override
    public Mono<UserDTO> get(UUID id) {
        return findById(id)
            .map(user -> modelMapper.map(user, UserDTO.class));
    }
    @Override
    public Mono<UserDTO> update(UUID id, CreateOrUpdateUserDto createOrUpdateuserDto) {
        User user = modelMapper.map(createOrUpdateuserDto, User.class);
        user.setId(id);
        return findById(id)
            .then(
                userRepository.update(user)
                .map(founduser -> modelMapper.map(founduser, UserDTO.class))
            );
    }
    @Override
    public Flux<UserDTO> getAll() {
        return userRepository.getAll().map(founduser -> modelMapper.map(founduser, UserDTO.class));
    }
}
