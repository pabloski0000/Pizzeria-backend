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
    

    public ImageDTO save(CreateOrUpdateImageDTO dto) throws IOException{
        throw new RuntimeException();
    }

    public BytesDTO get(UUID id){
        throw new RuntimeException();
    }

    
}
