package com.pizzeria.pizzeria.core.ConfigurationBeans;

import java.util.Date;
import java.util.UUID;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTgenerator {
    public static String getJWTToken(UUID userId) {
        String secretKey = "mySecretKey";
        String token = Jwts
          .builder()
          .setId("userId")      
          .setIssuedAt(new Date(System.currentTimeMillis()))
          .setExpiration(new Date(System.currentTimeMillis() + 3600000))
          .signWith(SignatureAlgorithm.HS512,
            secretKey.getBytes()).compact();
        return token;
       }
}
