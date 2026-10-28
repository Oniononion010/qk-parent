package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtils {

    @Value("${jwt.secret}")
    private String secret;

    public String makeToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                // 自定义载荷
                .setClaims(claims)
                // 签发时间
                .setIssuedAt(new Date())
                // 加密算法 + 秘钥
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                // 过期时间
                .setExpiration(new Date( System.currentTimeMillis()+1000 * 60 * 60 * 24L * 7))
                .compact();
       return  token;
    }
    public String makeToken(Map<String, Object> claims, Date expiration) {
        String token = Jwts.builder()
                // 自定义载荷
                .setClaims(claims)
                // 签发时间
                .setIssuedAt(new Date())
                // 加密算法 + 秘钥
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                // 过期时间
                .setExpiration(expiration)
                .compact();
       return  token;
    }

    //解析令牌

    public Map<String, Object> parseToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token)
                .getBody();

        return body;

    }
}
