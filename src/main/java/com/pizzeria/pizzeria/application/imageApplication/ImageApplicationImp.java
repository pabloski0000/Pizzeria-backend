package com.pizzeria.pizzeria.application.imageApplication;


import java.util.UUID;

import com.pizzeria.pizzeria.domain.imageDomain.Image;
import com.pizzeria.pizzeria.domain.imageDomain.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javassist.NotFoundException;
import reactor.core.publisher.Mono;
@Service
public class ImageApplicationImp implements ImageApplication{
    private ImageRepository imageRepository;
    private ModelMapper modelMapper;
    @Autowired
    public ImageApplicationImp(final ImageRepository imageRepository, final ModelMapper modelMapper){
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Mono<ImageDTO> add(MultipartFile multipartFile) throws Exception {
        CreateOrUpdateImageDTO createOrUpdateImageDto = new CreateOrUpdateImageDTO();
        createOrUpdateImageDto.setContent(multipartFile.getBytes());
        Image image = modelMapper.map(createOrUpdateImageDto, Image.class);
        image.setId(UUID.randomUUID());
        image.setThisNew(true);
        return imageRepository.add(image)
            .flatMap(added -> {
                if(!added){
                    return Mono.error(new Exception("The image wasn't saved correctly: " + createOrUpdateImageDto.getContent().toString()));
                }
                return Mono.just(modelMapper.map(image, ImageDTO.class));
            });
    }
    @Override
    public Mono<ImageDTO> findById(UUID id) {
        return imageRepository
            .findById(id)
            .switchIfEmpty(Mono.error(new NotFoundException("There isn't any image with id: " + id)))
            .map(contentImageInBytes -> {
                Image image = new Image();
                image.setId(id);
                image.setContent(contentImageInBytes);
                return modelMapper.map(image, ImageDTO.class);
            });
    }
}
