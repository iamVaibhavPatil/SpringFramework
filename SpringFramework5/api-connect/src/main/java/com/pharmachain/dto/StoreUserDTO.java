package com.pharmachain.dto;

import java.util.Set;

import lombok.Data;

@Data
public class StoreUserDTO {

	private String userName;
	private String password;
	private String status;
	private Set<String> roles;
	private String jwtToken;
}
