package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;

import com.pizzeria.pizzeria.core.ApplicationBase;
import com.pizzeria.pizzeria.domain.userDomain.User;
import com.pizzeria.pizzeria.domain.userDomain.UserRepository;
import com.pizzeria.pizzeria.core.ConfigurationBeans.JWTUtils;
import com.pizzeria.pizzeria.core.ConfigurationBeans.NanoIdUtils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserApplicationImpl extends ApplicationBase<User, UUID> implements UserApplication {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserApplicationImpl(UserRepository userRepository, ModelMapper modelMapper) {
        super(userRepository::findById);
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<UserOutDto> add(CreateUserDto createUserDto) {
        User user = modelMapper.map(createUserDto, User.class);
        user.setId(UUID.randomUUID());
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setThisNew(true);
        user.setProvider("LOGIN");
        UserOutDto userOutDto = this.modelMapper.map(user, UserOutDto.class);
        userOutDto.setAccessToken(JWTUtils.getJWTToken(user.getId()));
        userOutDto.setRefreshToken(NanoIdUtils.randomNanoId());
        return userRepository.add(user).then(Mono.just(userOutDto));
    }

    @Override
    public Mono<UserDto> get(UUID id) {
        return findById(id)
                .map(User -> modelMapper.map(User, UserDto.class));
    }

    @Override
    public Mono<Void> update(UUID id, CreateUserDto createOrUpdateUserDto) {
        User user = modelMapper.map(createOrUpdateUserDto, User.class);
        user.setId(id);
        return findById(id)
                .then(
                        userRepository.update(user));
    }
}
