package com.pharmachain.dto;

import java.util.List;

import lombok.Data;

@Data
public class ContactDTO {

	private Long contactId;
	private String name;
	private String email;
	private String department;
	private String designation;
	private List<PhoneDTO> phones;
}
