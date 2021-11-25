package com.pizzeria.pizzeria.domain.imageDomain;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.pizzeria.pizzeria.core.EntityBase;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Getter;
import lombok.Setter;
public @Getter @Setter class Image extends EntityBase{
    @NotEmpty
    private byte[] image;


    @Override
    public UUID getId(){
        return id;
    }
}



