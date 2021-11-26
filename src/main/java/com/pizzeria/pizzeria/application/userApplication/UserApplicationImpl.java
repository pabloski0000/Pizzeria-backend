package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;
import java.util.Date;

import com.pizzeria.pizzeria.core.ApplicationBase;
import com.pizzeria.pizzeria.core.exceptions.BadRequestException;
import com.pizzeria.pizzeria.domain.userDomain.User;
import com.pizzeria.pizzeria.domain.userDomain.UserProjection;
import com.pizzeria.pizzeria.domain.userDomain.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import reactor.core.publisher.Mono;

import org.mindrot.jbcrypt.BCrypt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
    public Mono<UserOutDto> add(CreateUserDto createUserDto) {
        User user = modelMapper.map(createUserDto, User.class);
        user.setId(UUID.randomUUID());
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setThisNew(true);
        //TODO validar email
        UserOutDto userDto = this.modelMapper.map(user, UserOutDto.class);
        userDto.setType("Bearer");
        userDto.setToken(getJWTToken(user.getName()));
        return userRepository.add(user).then(Mono.just(userDto));
            //.<String, User>validate(userRepository::findByEmail, user.getEmail())
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
                userRepository.update(user)
            );

    }
    private String getJWTToken(String firstname) {
        String secretKey = "mySecretKey";
        
        String token = Jwts
          .builder()
          .setId("softtekJWT")
          .setSubject(firstname)      
          .setIssuedAt(new Date(System.currentTimeMillis()))
          .setExpiration(new Date(System.currentTimeMillis() + 3600000))
          .signWith(SignatureAlgorithm.HS512,
            secretKey.getBytes()).compact();
      
        return token;
       }
}
