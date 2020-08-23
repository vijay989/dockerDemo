package com.loginapi.util;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenGenerator {

	String secretKey = "secretkey";

    private long validityInMilliseconds = 3600000; // 1h

	
	public String generateToken(UserDetails userDetails) {
		Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
	    Date now = new Date();
	    Date validity = new Date(now.getTime() + validityInMilliseconds);

	    return Jwts.builder()
	        .setClaims(claims)
	        .setIssuedAt(now)
	        .setExpiration(validity)
	        .signWith(SignatureAlgorithm.HS256, secretKey)
	        .compact();
	    }

	public boolean validateToken(String jwt, UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	public String extractUserName(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

//	  public boolean validateToken(String token) {
//	    try {
//	      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//	      return true;
//	    } catch (JwtException | IllegalArgumentException e) {
//	      throw new CustomException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	  }

}
