package com.pharmachain.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.pharmachain.domain.Role;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	@SuppressWarnings("unchecked")
	public Mono<Authentication> authenticate(Authentication authentication) {
		String authToken = authentication.getCredentials().toString();
		String userName;
		try {
			userName = jwtTokenProvider.getUserNameFromToken(authToken);
		} catch (Exception ex) {
			userName = null;
		}
		if (userName != null && jwtTokenProvider.validateToken(authToken)) {
			Claims claims = jwtTokenProvider.getAllClaimsFromToken(authToken);
			List<String> rolesMap = claims.get("roles", List.class);
			List<Role> roles = new ArrayList<Role>();
			for (String rolemap : rolesMap) {
				roles.add(Role.valueOf(rolemap));
			}
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, roles.stream().map(r -> new SimpleGrantedAuthority(r.name())).collect(Collectors.toList()));
			return Mono.just(auth);
		} else {
			return Mono.empty();
		}
	}
}
