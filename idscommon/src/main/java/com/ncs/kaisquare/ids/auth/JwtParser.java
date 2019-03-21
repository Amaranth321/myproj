package com.ncs.kaisquare.ids.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtParser {

    @Autowired
    private JwtConfig jwtConfig;

    public Jws<Claims> parseJwt(String token){
        Jws<Claims> jws = Jwts.parser().setSigningKey(jwtConfig.getSecret().getBytes()).parseClaimsJws(token);
        return jws;
    }

    public String getValueAsString(String token,String key){
        return parseJwt(token).getBody().get(key,String.class);
    }

}
