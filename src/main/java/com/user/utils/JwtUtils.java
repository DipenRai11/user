package com.user.utils;

import com.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static String secret="this_is_secret";
    public String generateJwt(User user){

        Date issuedAt=new Date();
        //CLAIMS
        Claims claims= Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt);

        //generate jwts using claims
        return Jwts.builder().setClaims(claims).compact();
    }
}
