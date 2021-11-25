package com.pizzeria.pizzeria.application.imageApplication;

import java.io.IOException;
import java.util.UUID;

import com.pizzeria.pizzeria.domain.imageDomain.Image;
import com.pizzeria.pizzeria.domain.imageDomain.ImageRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import com.pizzeria.pizzeria.core.ApplicationBase;
import com.pizzeria.pizzeria.core.functionalInterfaces.FindById;

@Service
public class ImageApplicationImp extends ApplicationBase<Image, UUID> implements ImageApplication{

    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    


    public Mono<ImageDTO> add(CreateOrUpdateImageDTO dto){
       Image image = modelMapper.map(dto, Image.class);
       image.setId(UUID.randomUUID());
       image.setThisNew(true);
       return this.imageRepository.add(image)
       .flatMap(monoImage -> Mono.just(this.modelMapper.map(monoImage, ImageDTO.classs)));
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imageRepository == null) ? 0 : imageRepository.hashCode());
        result = prime * result + ((modelMapper == null) ? 0 : modelMapper.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImageApplicationImp other = (ImageApplicationImp) obj;
        if (imageRepository == null) {
            if (other.imageRepository != null)
                return false;
        } else if (!imageRepository.equals(other.imageRepository))
            return false;
        if (modelMapper == null) {
            if (other.modelMapper != null)
                return false;
        } else if (!modelMapper.equals(other.modelMapper))
            return false;
        return true;
    }

    
}
