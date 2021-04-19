package com.example.crud.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	private static final String SECRET = "ASDKAFkaajsda!@%UYU:Ç^ÇLKTFDSASasdfgjho768690u6YERRT¨%&*(oi54235243%&*¨$(&*";

	private static final Long EXPIRATION_TIME = 1800000L;

	public String generateToken(String username) {

		return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
	}

	public boolean validToken(String token) {

		Claims claims = getClaims(token);

		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());

			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}

		return false;
	}

	public String getUsername(String token) {
		
		Claims claims = getClaims(token);
		
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
		
	}
		

	private Claims getClaims(String token) {

		try {
			return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}

}
