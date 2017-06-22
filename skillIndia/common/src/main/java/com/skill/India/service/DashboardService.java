package com.skill.India.service;

import java.util.Arrays;
import java.util.List;

import com.skill.India.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
	

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
	
	//@Autowired
	//private
	
	

}
