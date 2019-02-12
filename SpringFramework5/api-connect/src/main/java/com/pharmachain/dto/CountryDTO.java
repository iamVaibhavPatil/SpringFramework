package com.pharmachain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryDTO {
	private String countryCode;
	private String countryName;
}
