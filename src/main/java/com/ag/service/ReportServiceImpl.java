package com.ag.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ag.db.CitizenPlan;
import com.ag.db.CitizenPlanRepository;
import com.ag.dto.SearchRequest;
import com.ag.utils.DateUtils;

@Service
public class ReportServiceImpl implements ReportService {

	
	private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

	
	@Autowired
	CitizenPlanRepository repo;

	@Override
	public List<SearchRequest> getMatchedSearchRqst(SearchRequest rqst) {
		if (rqst.getPlanName().equals("-")) {
			log.info("Plan Name "+rqst.getPlanName());
			rqst.setPlanName(null);
		}

		if (rqst.getPlanStatus().equals("-")) {
			log.info("Plan Status "+rqst.getPlanStatus());
			rqst.setPlanStatus(null);
		}

		if (rqst.getGender().equals("-")) {
			log.info("Gender "+rqst.getGender());
			rqst.setGender(null);
		}

		if (rqst.getPlanStartDate().length() > 0) {
			String convertedDate = DateUtils.convertDateFormatInDBRedableFormat(rqst.getPlanStartDate());
			rqst.setPlanStartDate(convertedDate);
		} else {
			rqst.setPlanStartDate(null);
		}

		if (rqst.getPlanEndDate().length() > 0) {
			String convertedDate = DateUtils.convertDateFormatInDBRedableFormat(rqst.getPlanEndDate());
			rqst.setPlanEndDate(convertedDate);
		} else {
			rqst.setPlanEndDate(null);
		}

		List<SearchRequest> getAllMatchedReport = repo.getSearchResultByInput(rqst);
		return getAllMatchedReport;
	}

	@Override
	public List<String> getListOfPlans() {
		return repo.getDistinctPlanName();
	}

	@Override
	public List<String> getListOfPlanStatus() {
		return repo.getDistinctPlanStatus();
	}

	@Override
	public List<SearchRequest> getAllReports() {
		List<SearchRequest> finalData =  new ArrayList<>();
		List<CitizenPlan> allData = repo.findAll();
		System.out.println(allData.toString());
		allData.forEach(data->{
			SearchRequest result =  new SearchRequest();
			result.setId(data.getId());
			result.setCitizenName(data.getCitizenName());
			result.setGender(data.getGender());
			result.setPlanName(data.getPlanName());
			result.setPlanStatus(data.getPlanStatus());
			finalData.add(result);
		});
		return finalData;
	}

}
