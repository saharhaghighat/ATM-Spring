package com.atmspring.atmspring.utill;

import com.atmspring.atmspring.model.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
public class JwtUtils {

    @Value("${secret.key}")
    private String secretKey;

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public Date getExpirationDate(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }


    public boolean isTokenExpired(String token) {
        return getExpirationDate(token).before(new Date());
    }

    public boolean validateToken(String token) {
        try {
            String jwtToken= Optional.ofNullable(token)
                    .map(String::trim)
                    .orElseThrow();
            if (isTokenExpired(jwtToken)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public String generateToken(Account account) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("acc_Numb", account.getAccNumber());
        claims.put("uid", account.getUser().getId());
        return generateToken(claims, account.getUser().getNationalCode());

    }

    private String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 80000))
                .signWith(SignatureAlgorithm.HS512, secretKey).compact();
    }


}
