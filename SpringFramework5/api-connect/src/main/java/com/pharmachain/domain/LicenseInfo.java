package com.pharmachain.domain;

import lombok.Data;

@Data
public class LicenseInfo {
	private String licenseNumber;
	private String issueDate;
	private String expiryDate;
	private String imageUrl;
}
