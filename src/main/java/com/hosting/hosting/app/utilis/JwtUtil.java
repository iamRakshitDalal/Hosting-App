package com.hosting.hosting.app.utilis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.hosting.hosting.app.constants.Placeholders;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private String secretKey = Placeholders.SecretKey;

    private SecretKey getSigninKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    
    public String genrateToken(String username){
        Map<String,Object> claims = new HashMap<>();        
        return createToken(username, claims);
    }
    public String createToken(String username ,Map<String,Object> claims){
        return Jwts.builder()
        .claims(claims)
        .subject(username)
        .header().empty().add("typ","JWT")
        .and()
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis()+1000*60*60))
        .signWith(getSigninKey())
        .compact();
    }

    public String extractUsername(String token){
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser()
        .verifyWith(getSigninKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }      
    public Boolean validateToken(String token){
        return extractAllClaims(token).getExpiration().after(new Date());
    }
    
}