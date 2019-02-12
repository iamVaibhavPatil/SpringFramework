package com.pharmachain.domain;

import lombok.Data;

@Data
public class Address {
	private String type;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
}
