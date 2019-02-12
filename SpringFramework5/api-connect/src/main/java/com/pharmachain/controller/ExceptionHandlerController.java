package com.pharmachain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pharmachain.dto.ApiErrorDTO;
import com.pharmachain.exception.NotFoundException;
import com.pharmachain.exception.ServiceException;

@ControllerAdvice
public class ExceptionHandlerController {
	
	private ResponseEntity<ApiErrorDTO> buildResponse(ApiErrorDTO apiErrorDTO) {
		return new ResponseEntity<ApiErrorDTO>(apiErrorDTO, apiErrorDTO.getStatus()); 
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiErrorDTO> handleNotFoundException(NotFoundException ex) {
		ApiErrorDTO apiErrorDTO = new ApiErrorDTO(HttpStatus.NOT_FOUND);
		apiErrorDTO.setCode(ex.getErrorCode());
		apiErrorDTO.setMessage(ex.getErrorDescription());
		return buildResponse(apiErrorDTO);		
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ApiErrorDTO> handleServiceException(ServiceException ex) {
		ApiErrorDTO apiErrorDTO = new ApiErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR);
		apiErrorDTO.setCode(ex.getErrorCode());
		apiErrorDTO.setMessage(ex.getErrorDescription());
		return buildResponse(apiErrorDTO);
	}
}
