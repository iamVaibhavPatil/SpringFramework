package com.pharmachain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorDescription;
	
	public NotFoundException() {
		super();
	}

	public NotFoundException(String errorDescription) {
		super();
		this.errorCode = "P3600";
		this.errorDescription = errorDescription;
	}

	public NotFoundException(String errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public NotFoundException(String errorCode, String errorDescription, Throwable throwable) {
		super(errorDescription, throwable);
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
}
