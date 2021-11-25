package com.pizzeria.pizzeria.domain.imageDomain;

import javax.validation.constraints.NotBlank;

import com.pizzeria.pizzeria.core.EntityBase;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Getter;
import lombok.Setter;
public @Getter @Setter class Image extends EntityBase{
    @Column
    @NotBlank
    private byte[] image;
}



