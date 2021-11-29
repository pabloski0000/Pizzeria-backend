package com.pizzeria.pizzeria.application.imageApplication;

import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

public interface ImageApplication {
    Mono<ImageDTO> add(MultipartFile multipartFile) throws Exception;
    Mono<ImageDTO> findById(UUID id);
    
  
}
