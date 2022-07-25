
package com.tutorial.abml.Security.jwt;


import com.tutorial.abml.Security.entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class); // Le agregue el final que no estaba

    @Value("${jwt.secret}")//cambio {{ por {
    private String secret;
     
    @Value("${jwt.expiration}")//cambio {{ por {
    private int expiration;
     
    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();   
    }
    
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject(); //Jwt por Jws
    }

    public boolean validateToken(String token){ // cambie el nombre del Metodo de validatetoken a validateToken
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);// Jwt por Jws
            return true;
        }
        catch (MalformedJwtException e){
            logger.error("mal formado el token");
        }
        catch (UnsupportedJwtException e){
            logger.error("token no soportado" + e.getMessage());
        }
        catch (ExpiredJwtException e){
            logger.error("token expirado");
        }
        catch (IllegalArgumentException e){
            logger.error("token vacío");
        }
        catch (SignatureException e){
            logger.error("falla en la firma");
        }
        return false; 
    }
}