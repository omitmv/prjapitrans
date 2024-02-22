package com.prjapitrans.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prjapitrans.domain.Usuario;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

  private static final Logger LOGGER = LogManager.getLogger(JwtUtil.class);

  @Value("${var.key.secret}")
  private String SECRET_KEY;

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }

  private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public String generateToken(String jsonUsuario) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, jsonUsuario);
  }

  private String createToken(Map<String, Object> claims, String subject) {
    LOGGER.info("####### DEBUG 1: " + subject);
    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

  public Boolean validateToken(String token, UserDetails userDetails)
      throws JsonMappingException, JsonProcessingException {
    LOGGER.info("####### DEBUG 2: " + token + " - " + userDetails);
    final String stringUser = extractUsername(token);
    ObjectMapper mapper = new ObjectMapper();
    Usuario user = mapper.readValue(stringUser, Usuario.class);
    LOGGER.info("####### DEBUG 3: " + user);
    return (user.getLogin().equals(userDetails.getUsername()) && !isTokenExpired(token));
  }
}
