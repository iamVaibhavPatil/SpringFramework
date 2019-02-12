package com.pharmachain.dto;

import lombok.Data;

@Data
public class CompanyDTO {

	private Long companyId;
	private String companyCode;
	private String companyName;
	private String expiryReturnsAllowed;
	private String verified;
}
