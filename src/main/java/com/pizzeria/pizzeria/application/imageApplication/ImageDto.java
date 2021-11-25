package com.pizzeria.pizzeria.application.imageApplication;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {
    private UUID id;
    private byte[] content;
}
