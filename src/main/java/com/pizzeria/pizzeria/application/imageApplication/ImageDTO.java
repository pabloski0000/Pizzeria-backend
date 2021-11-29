package com.pizzeria.pizzeria.application.imageApplication;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
public @NoArgsConstructor @Getter @Setter class ImageDTO {
    public UUID id;
    private byte[] content;
}
