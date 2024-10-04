package com.Inventory.Inventory_Management.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")  // Load the secret key from application.properties
    private String secretKey;

    // Decode the secret key for signing and verification
    private byte[] getDecodedSecretKey() {
        return Base64.getDecoder().decode(secretKey);
    }

    public String getEmailFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getDecodedSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            // Handle token parsing exception
            return null;
        }
    }

    public boolean validateToken(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            // Handle token parsing exception
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(getDecodedSecretKey())
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration().before(new Date());
    }

    public List<GrantedAuthority> getAuthoritiesFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getDecodedSecretKey())
                    .parseClaimsJws(token)
                    .getBody();

            // Extract roles from claims
            List<Map<String, String>> roles = (List<Map<String, String>>) claims.get("roles");

            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.get("authority")))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            // Handle token parsing exception
            return List.of(); // Return an empty list if there's an error
        }
    }
}
