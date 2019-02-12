package com.pharmachain.domain;

import lombok.Data;

@Data
public class CreditInfo {
	private String creditPeriod;
	private String discountBefore;
	private String discountAfter;
	private String billingAmountLimit;
	private String orderAmountLimit;
}
