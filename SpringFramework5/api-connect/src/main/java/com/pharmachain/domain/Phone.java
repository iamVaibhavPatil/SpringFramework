package com.pharmachain.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Phone {

	private String type;
	private int code;
	private Long number;
}
