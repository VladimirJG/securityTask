package com.example.securityTask.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt_secret}")
    private String secret;

    public String generateToken(String username) {
        Date tokenExpirationDate = Date.from(ZonedDateTime.now().plusMinutes(60 * 24).toInstant());
        return JWT.create()
                .withSubject("User details")
                .withClaim("username", username)
                .withIssuedAt(new Date())
                .withIssuer("securityTaskApp")
                .withExpiresAt(tokenExpirationDate)
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User details")
                .withIssuer("securityTaskApp")
                .build();

        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getClaim("username").asString();
    }
}