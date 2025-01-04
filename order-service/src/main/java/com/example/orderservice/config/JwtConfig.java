package com.example.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;

@Configuration
public class JwtConfig {
    // IMPORTANT: Use the same secret key as in user-service
    private static final String JWT_SECRET = "ab88290e9ddf30d1513777c5ae425b72fd03bc7066a1aaf89d4c4ae5a8ccfdb9cef0c5e17f0b166b8be370b5abdd93e51b9140e45a335955a551209c39053bca4964905282aee99d170303c950beae5e3586fd82595746f50875807d4c26fae2c07ca39f5717c1427fc14cbcd7b0c60e38983a14d0acde5aa667ee8f7aa1194551f774830d1e8050c7693a32ec836ee7809654d0a791fe32460b387756252f5a77a31cd27e926e5154620df9782bf1515395891a29909a263fd2c1fa1d9f598ece7de19a6e704e62a0ca269fb20dfa15932f17a9ab8e9d2012cdc373ba893d2000292a4fe27bca764b684834ca39e42ae67bf4ff7fb832d169cda5893e2689fb";

    @Bean
    public SecretKey jwtSecretKey() {
        return Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
    }
}