package com.example.agritech.MobileApp.JWT;

import com.example.agritech.WebApp.Model.AppUsers;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class jwtUtility implements Serializable {
     public static  final long serialVersionUID = 234234543423L;
     public  final long JWT_TOKEN_VALIDITY = 5*60*60;

     @Value("${jwt.secret}")
    private String secretKey;

     //how to get details from the token
    public  String getUserNameFromToken( String token){
        return getClaimFromToken(token, Claims::getSubject);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // retrieving any infor from token
    private  Claims getAllClaimsFromToken(String token){
        return  Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    // how to generate a token
    public String generateToken(AppUsers appUsers){
        Map<String, Object> claims = new HashMap<>();
        return  generatedToken(claims, appUsers.getUsername());
    }

    private String generatedToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).
                setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY* 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }

    // validation of the generated token
    public Boolean validateToken(String token, AppUsers appUsers){
        final String username = getUserNameFromToken(token);
        return (username.equals(appUsers.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration =  getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        return null; // modify here
    }


}
