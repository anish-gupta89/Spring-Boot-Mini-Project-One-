package com.ag.dto;

import lombok.Data;

@Data
public class SearchRequest {

	private Integer Id;

	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private String planStartDate;
	private String planEndDate;
	private Integer benefitAmount;
	private String denialRsn;
	private String terminatedDate;
	private String terminationRsn;
	
	
	
	

}
