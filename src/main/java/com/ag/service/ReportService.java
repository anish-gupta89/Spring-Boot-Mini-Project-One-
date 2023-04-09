package com.ag.service;

import java.util.List;

import com.ag.dto.SearchRequest;

public interface ReportService {

	public List<SearchRequest> getMatchedSearchRqst(SearchRequest rqst);

	public List<String> getListOfPlans();

	public List<String> getListOfPlanStatus();
	
	public List<SearchRequest> getAllReports();
}
