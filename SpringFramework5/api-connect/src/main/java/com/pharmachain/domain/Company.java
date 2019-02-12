package com.pharmachain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "companies")
@Data
@EqualsAndHashCode(callSuper = false)
public class Company extends AuditEntity {

	private static final long serialVersionUID = 1L;

	@Id
	private Long companyId;
	
	@Indexed
	private String companyCode;
	
	@Indexed
	private String companyName;

	private String expiryReturnsAllowed;
	private String verified;
}
