package com.skill.India.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDao;
import com.skill.India.dao.DashboardPanelsDao;
import com.skill.India.dao.DashboardTotalBatchesAccordingToJobRoleDao;
import com.skill.India.dao.DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDao;
import com.skill.India.dao.DashboardTopStatesWithMaxTrainingCentersDao;
import com.skill.India.dto.DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto;
import com.skill.India.dto.DashboardTotalBatchesAccordingToJobRoleDto;
import com.skill.India.dto.DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto;
import com.skill.India.dto.DashboardTopStatesWithMaxTrainingCentersDto;


 

@Service
public class DashboardService  {

	@Autowired
	private DashboardPanelsDao dashboardPanelsDao;
	
	@Autowired 
	DashboardTotalBatchesAccordingToJobRoleDao dashboardPieChartDao;
	
	@Autowired
	DashboardTopStatesWithMaxTrainingCentersDao dashboardTopStatesDao;
	
	@Autowired
	DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDao dashboardStackedColumnChartDao;
	
	@Autowired
	DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDao dashboardColumnChartDao;
	
	
	public Integer getTotalCandidatesEnrolled() {
		 return dashboardPanelsDao.getTotalCandidateEnrolled();
	}
	
	public Integer getTotalCandidatesAccessed() {
		 return dashboardPanelsDao.getTotalCandidateAccessed();
	}
	
	public Integer getTotalCandidatesCertified() {
		 return dashboardPanelsDao.getTotalCandidateCertified();
	}
	
	public Integer getTotalTrainingCentersInIndia() {
		 return dashboardPanelsDao.getTotalTrainingCentersInIndia();
	}
	
	public Integer getTotalTrainingPartners() {
		 return dashboardPanelsDao.getTotalTrainingPartners();
	}
	
	public Collection<DashboardTotalBatchesAccordingToJobRoleDto> getTotalBatchesAccordingToJobRole() {
		return dashboardPieChartDao.getTotalBatchesAccordingToJobRole();
	}
	
	
public Collection<DashboardTopStatesWithMaxTrainingCentersDto> getTopStatesWithMaxTrainingCenters() {
	
	return dashboardTopStatesDao.getTopStatesWithMaxTrainingCenters();
}

public Collection<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> getTotalCandidatesCertifiedWithModeInLastThreeYears() {
	
	return dashboardStackedColumnChartDao.getTotalCandidatesCertifiedWithModeInLastThreeYears();
	
}

public Collection<DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto> getTotalCandidatesTrainedWithBatchTypeInLastThreeYears() {
	return dashboardColumnChartDao.getTotalCandidatesTrainedWithBatchTypeInLastThreeYears();
}


	
}