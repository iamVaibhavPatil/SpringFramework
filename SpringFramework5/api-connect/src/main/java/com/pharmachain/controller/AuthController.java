package com.pharmachain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pharmachain.dto.StoreUserDTO;
import com.pharmachain.service.AuthService;
import com.pharmachain.util.Constants;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Constants.API_URL + "/auth")
public class AuthController {

	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ResponseEntity<?>> authenticateUser(@RequestBody StoreUserDTO userDTO) {
		return authService.authenticateUser(userDTO).map(userDTOResponse -> {
			if(userDTOResponse.getJwtToken() != null) {
				return ResponseEntity.ok(userDTOResponse);
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/register")
	public Mono<StoreUserDTO> registerUser(@RequestBody StoreUserDTO userDTO) {
		return authService.registerUser(userDTO);
	}
}
