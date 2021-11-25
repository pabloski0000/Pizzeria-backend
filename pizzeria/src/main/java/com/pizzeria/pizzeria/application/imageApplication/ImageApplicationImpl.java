package com.pizzeria.pizzeria.application.imageApplication;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.imageDomain.Image;
import com.pizzeria.pizzeria.domain.imageDomain.ImageRepository;
import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ImageApplicationImpl implements ImageApplication {
    private ImageRepository imageRepository;
    private ModelMapper modelMapper;
    @Autowired
    public ImageApplicationImpl(final ImageRepository imageRepository, final ModelMapper modelMapper){
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Mono<ImageDto> findById(UUID id) {
        return imageRepository.findById(id).map(foundImage -> modelMapper.map(foundImage, ImageDto.class));
    }
    
}
