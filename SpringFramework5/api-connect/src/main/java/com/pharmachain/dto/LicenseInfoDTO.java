package com.pharmachain.dto;

import lombok.Data;

@Data
public class LicenseInfoDTO {
	private String licenseNumber;
	private String issueDate;
	private String expiryDate;
	private String imageUrl;
}
