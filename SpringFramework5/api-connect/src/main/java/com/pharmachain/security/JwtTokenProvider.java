package com.pharmachain.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pharmachain.config.JwtConfiguration;
import com.pharmachain.domain.StoreUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	@Autowired
	private JwtConfiguration jwtConfiguration;
    
    public Claims getAllClaimsFromToken(String token) {
		return Jwts
				.parser()
				.setSigningKey(jwtConfiguration.getSecret())
				.parseClaimsJws(token)
				.getBody();
	}
    
	public String getUserNameFromToken(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getAllClaimsFromToken(token).getExpiration();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	public String generateToken(StoreUser user) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("roles", user.getRoles());
		return doGenerateToken(claims, user.getUserName());
	}
	
	private String doGenerateToken(Map<String, Object> claims, String userName) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtConfiguration.getExpiration());

		return Jwts
				.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtConfiguration.getSecret())
				.compact();
	}
	
	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}
}