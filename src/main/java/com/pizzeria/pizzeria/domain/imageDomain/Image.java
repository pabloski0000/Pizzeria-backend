package com.pizzeria.pizzeria.domain.imageDomain;

import com.pizzeria.pizzeria.core.EntityBase;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("images")
@Getter
@Setter
public class Image extends EntityBase {
    @Column
    private byte[] content;
}
