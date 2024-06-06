package kairya.tga.tgaREST.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import kairya.tga.tgaREST.model.Usuario;


@Service
public class JwtService {

    private static final String SECRET_KEY = "1nn6FLCOuSAnzUsob9lSsBq5z2gTbhoz-ygO2jRvILU";

    public String getToken(UserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("nombre", ((Usuario) user).getNombre());
        claims.put("apellidos", ((Usuario) user).getApellidos());
        claims.put("correo", ((Usuario) user).getCorreo());
        return getToken(claims, user);
    }

    private String getToken(Map<String , Object > extraClaims, UserDetails user) {
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

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public Usuario getUsuarioFromToken(String token) {
        Claims claims = Jwts.parser()
            .verifyWith(getKey())
            .build().parseSignedClaims(token).getPayload();
        String correo = (String) claims.get("correo");
        String nombre = (String) claims.get("nombre");
        String apellidos = (String) claims.get("apellidos");
        return new Usuario(correo, null, nombre, apellidos, null);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    private Claims getAllClaims(String token){
        return Jwts
        .parser()
        .verifyWith(getKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }

}
