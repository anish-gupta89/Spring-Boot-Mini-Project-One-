package com.ag.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ag.dto.SearchRequest;
import com.ag.utils.DateUtils;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Serializable> {
	

	@Query(value = "SELECT distinct(planName) from CitizenPlan", nativeQuery = false)
	List<String> getDistinctPlanName();

	@Query(value = "SELECT distinct(planStatus) from CitizenPlan", nativeQuery = false)
	List<String> getDistinctPlanStatus();

	default List<SearchRequest> getSearchResultByInput(SearchRequest request) {

		CitizenPlan planObj = new CitizenPlan();
		if (request.getPlanStartDate() != null) {
			planObj.setPlanStartDate(DateUtils.getDateFromString(request.getPlanStartDate()));
		}

		if (request.getPlanEndDate() != null) {
			planObj.setPlanEndDate(DateUtils.getDateFromString(request.getPlanEndDate()));
		}

		List<SearchRequest> finalData = new ArrayList<>();

		planObj.setPlanName(request.getPlanName());
		planObj.setPlanStatus(request.getPlanStatus());
		planObj.setGender(request.getGender());

		
		System.out.println("RQ Value" + request);
		
		System.out.println("CP Value" + planObj);
		
		Example<CitizenPlan> req = Example.of(planObj);
	
		List<CitizenPlan> findAll = findAll(req);
		
		
		System.out.println("findAll" + findAll);
		
		
		findAll.forEach(data -> {
			SearchRequest dataObj = new SearchRequest();
			dataObj.setId(data.getId());
			dataObj.setCitizenName(data.getCitizenName());
			dataObj.setGender(data.getGender());
			dataObj.setPlanName(data.getPlanName());
			dataObj.setPlanStatus(data.getPlanStatus());
			if (data.getPlanStartDate() != null) {
				dataObj.setPlanStartDate(data.getPlanStartDate().toString());
			} else {
				dataObj.setPlanStartDate("");
			}

			if (data.getPlanEndDate() != null) {
				dataObj.setPlanEndDate(data.getPlanEndDate().toString());
			} else {
				dataObj.setPlanEndDate("");
			}

			dataObj.setBenefitAmount(data.getBenefitAmount());
			dataObj.setDenialRsn(data.getDenialRsn());
			if (data.getTerminatedDate() != null) {
				dataObj.setTerminatedDate(data.getTerminatedDate().toString());
			} else {
				dataObj.setTerminatedDate("");
			}

			dataObj.setTerminationRsn(data.getTerminationRsn());
			finalData.add(dataObj);
		});

		return finalData;

	}

}
