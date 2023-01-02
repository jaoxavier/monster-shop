package io.github.jaoxavier.monstershop.service.jwt.security;

import io.github.jaoxavier.monstershop.domain.entity.Client;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.expiration}")
    private String expiration;

    @Value("${security.jwt.keySigned}")
    private String keySigned;

    public String generateToken(Client client){
        long exp = Long.valueOf(this.expiration);
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(exp);
        Instant instant = expirationTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(client.getUsername())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, keySigned)
                .compact();
    }

    public Claims getClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(keySigned)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token){
        try {
            Claims claims = getClaims(token);
            Date expirationDate = claims.getExpiration();
            LocalDateTime date = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(date);
        }catch (Exception exception){
            return false;
        }
    }

    public String getLoginUser(String token){
        return (String) getClaims(token).getSubject();
    }

}
