//package com.riwi.superSchool.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//
//    private static final String SECRET_KEY = "c74162578c7ba0abdfcebd0fa99ba4965009cabc5c6791e6ca61e14b9f58d178";
//
//    //this class is to generate a token
//    public String generateToken(
//            Map<String, Object> extraClaims,
//            UserDetails userDetails
//    ) {
//        return Jwts
//                .builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+1000+60+24))
//                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        return generateToken(new HashMap<>(), userDetails);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//
//    private Key getSignInKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    //This is to extract the claims out of the token
//    private Claims extractClaims(String token) {
//        return Jwts
//                .parser()
//                .setSigningKey(getSignInKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    // this is to extract token expiration date
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    //this is to check if the token is already expired
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    //This is to check if the token is valid
//    public boolean isTokenValid(String token, UserDetails userDetails){
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()))&&!isTokenExpired(token);
//    }
//
//
//
//}
