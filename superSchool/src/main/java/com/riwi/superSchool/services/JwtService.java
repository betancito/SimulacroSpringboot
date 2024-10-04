package com.riwi.superSchool.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+expiration))
                .and()
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    //section to extract username from the JWT
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String jwtToken) {
        return extractClaims(jwtToken).getSubject();
    }

    public boolean isTokenExpired(String jwtToken) {
        return extractClaims(jwtToken).getExpiration().before(new Date());
    }

    public boolean validateToken(String jwtToken, String username) {
        return (username.equals(extractUsername(jwtToken)) && !isTokenExpired(jwtToken));
    }




}
