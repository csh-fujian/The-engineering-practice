package com.whch.presentCloud.utils;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
public class TokenUtil {
    private static final String secret = "secret";
    public static final String tokenHeard = "token";
    private static final Long expTime = 60 * 5 * 1000L;

    public static String getToken(String name,String id,String ip) {
        JwtBuilder builder = Jwts.builder();
        builder.signWith(SignatureAlgorithm.HS256,secret);
        builder.setId(id).setSubject(name).setAudience(ip);
        builder.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expTime));
        String token = builder.compact();
        return token;
    }

    public static Claims getTokenBody(String token) {
        JwtParser parser = Jwts.parser();
        Claims body = parser.setSigningKey(secret).parseClaimsJws(token).getBody();
        return body;
    }

    public static String getName(String token) {
        Claims body = getTokenBody(token);
        String id = body.getId();
        return id;
    }


    public static void main(String[] args) {
        /**
         * 测试生成一个token
         */
        String sign = getToken("18888888888", "123456","12.0");
       System.out.println("测试生成一个token\n"+sign);
    }
}