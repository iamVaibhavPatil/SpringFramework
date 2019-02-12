package com.pharmachain.dto;

import lombok.Data;

@Data
public class CreditInfoDTO {
	private String creditPeriod;
	private String discountBefore;
	private String discountAfter;
	private String billingAmountLimit;
	private String orderAmountLimit;
}
