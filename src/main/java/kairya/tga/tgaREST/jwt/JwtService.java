package kairya.tga.tgaREST.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {

    private static final String SECRET_KEY = "1nn6FLCOuSAnzUsob9lSsBq5z2gTbhoz-ygO2jRvILU";

    public String getToken(UserDetails user) {
        // TODO Auto-generated method stub
        return getToken(new HashMap<>(), user);
    }

    private String getToken(Map<String , Object > extraClaims, UserDetails user) {
        // TODO Auto-generated method stub
        return Jwts.builder()
            .claims(extraClaims)
            .subject(user.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getKey())
            .compact();
    }

    private SecretKey getKey() {
        byte[] secretBytes = Decoders.BASE64URL.decode(SECRET_KEY);  
        return Keys.hmacShaKeyFor(secretBytes); 
    }

}
