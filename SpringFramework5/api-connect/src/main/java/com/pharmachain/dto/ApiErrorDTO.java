package com.pharmachain.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiErrorDTO {

	private HttpStatus status;
	private String code;
	private String message;
	private List<FieldError> fieldErrors;
	private LocalDateTime timestamp;
	
	public ApiErrorDTO() {
		timestamp = LocalDateTime.now();
	}
	
	public ApiErrorDTO(HttpStatus status) {
		this();
		this.status = status;
	}
	
	public ApiErrorDTO(HttpStatus status, String code, String message) {
		this();
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public void addFieldError(FieldError fieldError) {
		this.fieldErrors.add(fieldError);
	}

	@Data
	@AllArgsConstructor
	class FieldError {
		private String field;
		private String message;
	}
}
