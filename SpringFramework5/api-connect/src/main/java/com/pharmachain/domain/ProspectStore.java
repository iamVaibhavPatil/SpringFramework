package com.pharmachain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "prospect_stores")
@Data
@EqualsAndHashCode(callSuper = false)
public class ProspectStore extends AuditEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long prospectId;

	@Indexed
	private String storeType;
	
	@Indexed
	private String storeRegion;
	
	@Indexed
	private String storeName;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String verified;
}
