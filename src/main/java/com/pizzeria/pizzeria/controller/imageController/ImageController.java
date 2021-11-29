package com.pizzeria.pizzeria.controller.imageController;

import java.util.UUID;

import com.pizzeria.pizzeria.application.imageApplication.ImageApplication;
import com.pizzeria.pizzeria.application.imageApplication.ImageDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/v2/images")
public class ImageController {
    private ImageApplication imageApplication;
    @Autowired
    public ImageController(final ImageApplication imageApplication){
        this.imageApplication = imageApplication;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Mono<ImageDTO> getImage(@PathVariable UUID id) {
        return imageApplication.findById(id);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ImageDTO> add(@RequestParam("image") MultipartFile multipartFile) throws Exception {
        return imageApplication.add(multipartFile);
    }
}
