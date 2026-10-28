package cn.itcast;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestJWT {


    @Test
    public void test(){
        byte[] itheimas1 = TextCodec.BASE64.decode("itheima");
        System.out.println(Arrays.toString(itheimas1));
        byte[] itheimas2 = TextCodec.BASE64.decode("ithe");
        System.out.println(Arrays.toString(itheimas2));

        System.out.println(Arrays.toString("itheima".getBytes()));
        System.out.println(Arrays.toString("ithei".getBytes()));
    }

    // 造令牌

    @Test
    public void makeToken(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("name","梅军建");
        claims.put("id",1);

        String token = Jwts.builder()
                // 自定义载荷
                .setClaims(claims)
                // 签发时间
                .setIssuedAt(new Date())
                // 加密算法 + 秘钥
                .signWith(SignatureAlgorithm.HS256, "itheima".getBytes())
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60*24))
                .compact();

        System.out.println(token);

    }

    //解析令牌

    @Test
    public void parseToken(){

        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi5qKF5Yab5bu6IiwiaWQiOjEsImV4cCI6MTc4NTgzMzQ2MCwiaWF0IjoxNzg1NzQ3MDU5fQ.5Wtn752GNcsQ0NhGaPlLUwtotfnVUwbtz90cRmoWTzM";

        Claims body = Jwts.parser()
                .setSigningKey("ithei".getBytes())
                .parseClaimsJws(token)
                .getBody();

        System.out.println(body);

    }
}
