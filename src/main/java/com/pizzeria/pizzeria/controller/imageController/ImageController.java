/*package com.pizzeria.pizzeria.controller.imageController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import reactor.core.publisher.Mono;

public class ImageController {
    private final ImageService imageService;

    @PostMapping("/image")
    Mono<CreateImageResponse> create(@RequestBody CreateImageRequest request) {
        return imageService.shortenImage(request.getImage())
                          .map(CreateImageResponse::new);
    }

    @GetMapping("/{byte[]}")
    Mono<ResponseEntity<Object>> getImagek(@PathVariable String key) {
        return imageService.getOriginalImage(key)
                          .map(image -> ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                                                     .header("Location", link.getOriginalLink())
                                                     .build())
                          .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Value
    public static class CreateImageRequest {

        private String image;
    }

    @Value
    public static class CreateImageResponse {

        private String shortenedImage;
    }  
}
*/