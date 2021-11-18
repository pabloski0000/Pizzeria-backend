package com.pizzeria.pizzeria.core;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter abstract class EntityBase {
    @Id
    @Type(type = "uuid-binary")
    @Column(columnDefinition = "binary(16)")
    private UUID id;
    @Override
    public boolean equals (Object obj) {

        if (!(obj instanceof EntityBase)){
            return false;
        }

        EntityBase tmpEntity = (EntityBase) obj;

        return this.id.equals(tmpEntity.id);
    }

    @Override
    public int hashCode(){
        return this.id.hashCode();
    }
}
