package com.pharmachain.dto;

import lombok.Data;

@Data
public class AddressDTO {
	private String type;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
}
