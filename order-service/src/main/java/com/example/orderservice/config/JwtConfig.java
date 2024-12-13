package com.example.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;

@Configuration
public class JwtConfig {
    // IMPORTANT: Use the same secret key as in user-service
    private static final String JWT_SECRET = "your-secret-key-must-be-at-least-256-bits-long-and-very-secure";

    @Bean
    public SecretKey jwtSecretKey() {
        return Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
    }
}