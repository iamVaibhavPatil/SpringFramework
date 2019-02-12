package com.pharmachain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "stores")
@Data
@EqualsAndHashCode(callSuper = false)
public class Store extends AuditEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long storeId;

	@Indexed
	private String storeType;
	
	@Indexed
	private String storeRegion;
	
	@Indexed
	private String storeName;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private Address address;
	private TaxInfo taxInfo;
	private LicenseInfo licenseInfo;
	private CreditInfo creditInfo;
	private String verified;
	private String status;
}
