package com.example.post_service.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	// private final String secretKey =
	// "my-secret-key-which-needs-to-be-long-enough";

	@Value("${app.jwt.secret}")
	private String secretKey;
	// private final long jwtExpirationMs = 86400000; // 1 day

//	public String extractUsername(String token) {
//		return extractClaim(token, Claims::getSubject);
//	}

//	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = parseToken(token);
//		return claimsResolver.apply(claims);
//	}

	public Long extractUserId(String token) {
		final Claims claims = parseToken(token);
		Long userId = claims.get("userId", Long.class);
		return userId;
	}
	
	public String extractUserName(String token) {
		final Claims claims = parseToken(token);
		String username = claims.getSubject();
		return username;
	}

	private Claims parseToken(String token) {
		return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes())).build()
				.parseClaimsJws(token).getBody();
	}

	public boolean isTokenValid(String token) {
		try {
			parseToken(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
