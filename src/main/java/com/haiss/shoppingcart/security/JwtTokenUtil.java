package com.haiss.shoppingcart.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;


interface IJwtTokenUtil {

    String genrateToken(Authentication authentication);

    String getUsernameFromJwt(String token);

    boolean validateToken(String token) throws AuthenticationException;
}

@Component
public class JwtTokenUtil implements IJwtTokenUtil {

    @Value("${app.JWT.EXPIRY}")
    private Long EXPIRY_MILLIS;

    @Value("${app.JWT.SECRET}")
    private String JWT_SECRET;



    private SecretKey getThe_JWT_SECRET() {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(JWT_SECRET));

    }

    @Override
    public String genrateToken(Authentication authentication) {
        String username = authentication.getName();

        Instant expiryInstant = Instant.now().plusMillis(EXPIRY_MILLIS);
        Date expiryDate = Date.from(expiryInstant);

        return Jwts.builder().subject(username).issuedAt(new Date()).expiration(expiryDate).signWith(getThe_JWT_SECRET()).compact();
    }

    @Override
    public String getUsernameFromJwt(String token) {
        return Jwts.parser().verifyWith(getThe_JWT_SECRET()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    @Override
    public boolean validateToken(String token) throws AuthenticationException {
        try {

            Jwts.parser().verifyWith(getThe_JWT_SECRET()).build().parseSignedClaims(token);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}

