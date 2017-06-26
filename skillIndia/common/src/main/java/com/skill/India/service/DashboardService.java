package com.skill.India.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.DashboardDao;
import com.skill.India.dto.DashboardDto;


 

@Service
public class DashboardService  {

	@Autowired
	private DashboardDao dashboardDao;
	
	public Integer getCandidatesEnrolled() {
		 return dashboardDao.getTotalCandidateEnrolled();
	}
	
	public Integer getCandidatesAccessed() {
		 return dashboardDao.getTotalCandidateAccessed();
	}
	
	public Integer getCandidatesCertified() {
		 return dashboardDao.getTotalCandidateCertified();
	}
	
	public Integer getTrainingCenters() {
		 return dashboardDao.getTotalTrainingCenter();
	}
	
	public Integer getTrainingPartners() {
		 return dashboardDao.getTotalTrainingPartners();
	}
	private List<DashboardDto> dashboardDto=Arrays.asList(
	new DashboardDto("Delhi",125),
	new DashboardDto("Bihar", 1010),
	new DashboardDto("Chennai",145),
	new DashboardDto("Mumbai", 10),
	new DashboardDto("Bikaner",300)
	);
public List<DashboardDto> getStates(){
return dashboardDto;
}


	
}