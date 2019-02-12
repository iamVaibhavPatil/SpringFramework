package com.pharmachain.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Contact extends AuditEntity {

	private static final long serialVersionUID = 1L;

	@Id
	private Long contactId;

	private String name;
	private String email;
	private String department;
	private String designation;
	private List<Phone> phones;
}
