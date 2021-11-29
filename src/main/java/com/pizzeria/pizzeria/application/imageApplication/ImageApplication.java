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
public interface ImageApplication {
    public ImageDTO add(CreateOrUpdateImageDTO dto) throws IOException;
    public BytesDTO findById(UUID id);
    
  
}
