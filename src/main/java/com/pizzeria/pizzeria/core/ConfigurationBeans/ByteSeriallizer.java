package com.pizzeria.pizzeria.core.ConfigurationBeans;


import org.hibernate.type.SerializationException;
import org.springframework.data.redis.serializer.RedisSerializer;

import lombok.NoArgsConstructor;

public class ByteSeriallizer implements RedisSerializer<byte[]>{
    @Override
    public byte[] serialize(byte[] t) throws SerializationException {
        return t;
    }
 
    @Override
    public byte[] deserialize(byte[] bytes) throws SerializationException {
        return bytes;
    }
}
