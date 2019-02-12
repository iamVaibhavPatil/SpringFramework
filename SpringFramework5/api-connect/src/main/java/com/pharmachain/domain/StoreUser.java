package com.pharmachain.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "store_users")
@Data
@EqualsAndHashCode(callSuper = false)
public class StoreUser extends AuditEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long storeUserId;
	
	private Long storeId;

	@Indexed
	private String userName;
	
	private String password;
	
	private String status;
	
	private Set<String> roles;
}
