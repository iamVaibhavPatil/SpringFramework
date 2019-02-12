package com.pharmachain.dto;

import lombok.Data;

@Data
public class StoreDTO {
	private Long storeId;
	private String storeType;
	private String storeRegion;
	private String storeName;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private AddressDTO address;
	private TaxInfoDTO taxInfo;
	private LicenseInfoDTO licenseInfo;
	private CreditInfoDTO creditInfo;
	private String verified;
	private String status;
}
