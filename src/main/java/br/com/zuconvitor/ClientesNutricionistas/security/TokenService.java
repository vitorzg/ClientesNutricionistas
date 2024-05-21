package br.com.zuconvitor.ClientesNutricionistas.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.zuconvitor.ClientesNutricionistas.models.Nutricionistas;

@Service
public class TokenService {
    
    @Value("teste-api")
    private String secret;

    public String generatedToken(Nutricionistas nutricionistas){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                                    .withIssuer("auth-api")
                                    .withSubject(nutricionistas.getEmail())
                                    .withExpiresAt(genExpirationDate())
                                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToke(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                                        .withIssuer("auth-api")
                                        .build()
                                        .verify(token)
                                        .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }
}
