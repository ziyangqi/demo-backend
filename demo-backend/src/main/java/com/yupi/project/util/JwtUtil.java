package com.yupi.project.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "flow.jwt")
public class JwtUtil {
    public static final String USERID = "userNo";
    public static final String APPID = "tenantId";
    @Setter @Getter
    private long expire;
    @Setter @Getter
    private String secretKey;


    private SecretKey KEY;
    @PostConstruct
    private void createKEY(){
        if(secretKey == null){
            secretKey = UUID.randomUUID().toString();
        }
        this.KEY = Keys.hmacShaKeyFor(this.secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(String userNo,String tenantId){
        return Jwts.builder()
                .claims(this.createClaims(userNo,tenantId))
                .expiration(this.createExpire())
                .signWith(this.KEY)
                .compact();

    }
    public Claims parseToken(String token) throws JwtException {
        return Jwts.parser()
                .verifyWith(this.KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Map<String, String> createClaims(String userNo, String tenantId){
        return Map.of(USERID, userNo,APPID, tenantId);
    }

    private Date createExpire(){
        return new Date(System.currentTimeMillis() + this.expire);
    }
}