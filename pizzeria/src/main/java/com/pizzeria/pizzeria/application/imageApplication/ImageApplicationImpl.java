package com.pizzeria.pizzeria.application.imageApplication;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.imageDomain.Image;
import com.pizzeria.pizzeria.domain.imageDomain.ImageRepository;
import com.pizzeria.pizzeria.domain.ingredientDomain.Ingredient;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javassist.NotFoundException;
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
    public Mono<ImageDto> add(MultipartFile multipartFile) throws Exception {
        CreateOrUpdateImageDto createOrUpdateImageDto = new CreateOrUpdateImageDto();
        createOrUpdateImageDto.setContent(multipartFile.getBytes());
        Image image = modelMapper.map(createOrUpdateImageDto, Image.class);
        image.setId(UUID.randomUUID());
        image.setThisNew(true);
        return imageRepository.add(image)
            .flatMap(added -> {
                if(!added){
                    //Look error code up
                    return Mono.error(new Exception("The image wasn't saved correctly: " + createOrUpdateImageDto.getContent().toString()));
                }
                return Mono.just(modelMapper.map(image, ImageDto.class));
            });
    }
    @Override
    public Mono<ImageDto> findById(UUID id) {
        return imageRepository
            .findById(id)
            .switchIfEmpty(Mono.error(new NotFoundException("There isn't any image with id: " + id)))
            .map(contentImageInBytes -> {
                Image image = new Image();
                image.setId(id);
                image.setContent(contentImageInBytes);
                return modelMapper.map(image, ImageDto.class);
            });
    }
    
}
