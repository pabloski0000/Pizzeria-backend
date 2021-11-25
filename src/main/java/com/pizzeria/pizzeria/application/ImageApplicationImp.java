package com.pizzeria.pizzeria.application.imageApplication;

import java.io.IOException;
import java.util.UUID;

import com.pizzeria.pizzeria.domain.imageDomain.Image;
import com.pizzeria.pizzeria.domain.imageDomain.ImageRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import com.pizzeria.pizzeria.core.ApplicationBase;
import com.pizzeria.pizzeria.core.functionalInterfaces.FindById;

@Service
public class ImageApplicationImp extends ApplicationBase<Image, UUID> implements ImageApplication{

    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    

    @Autowired
    public ImageApplicationImp(final ImageRepository imageRepository,final ModelMapper modelMapper){
        super((id) -> imageRepository.get(id));
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }

    public Mono<ImageDTO> add(CreateOrUpdateImageDTO dto){
       Image image = modelMapper.map(dto, Image.class);
       image.setId(UUID.randomUUID());
       image.setThisNew(true);
       return this.imageRepository.add(image)
       .flatMap(monoImage -> Mono.just(this.modelMapper.map(monoImage, ImageDTO.classs)));
    }

    public BytesDTO get(UUID id){
        BytesDTO bytesDTO = modelMapper.map(this.findById(id), BytesDTO.class);
    }

    
}
