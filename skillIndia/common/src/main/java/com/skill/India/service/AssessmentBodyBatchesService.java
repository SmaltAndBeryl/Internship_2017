package com.skill.India.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;





//import org.assertj.core.extractor.Extractors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.thymeleaf.expression.Lists;






//import com.ibm.icu.text.DateFormat;
//import com.ibm.icu.text.SimpleDateFormat;
//import com.lowagie.text.List;
import com.skill.India.dao.AssessmentBodyBatchesDao;
import com.skill.India.dto.AssessmentBodyBatchesDto;

@Service
public class AssessmentBodyBatchesService {
	
	
	
	@Autowired
	private AssessmentBodyBatchesDao updateDao;
	
//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	Date date = new Date();
//	System.out.println(dateFormat.format(date));
	
	public HashMap<String, ArrayList<AssessmentBodyBatchesDto>> getUpdateRowMapper(){
		//System.out.println("LIST 1 Code reached");
		
		
		ArrayList<AssessmentBodyBatchesDto> pastBatches= new ArrayList<AssessmentBodyBatchesDto>();
		ArrayList<AssessmentBodyBatchesDto> upcomingBatches= new ArrayList<AssessmentBodyBatchesDto>();
		
		 Collection<AssessmentBodyBatchesDto> ab= updateDao.getUpdateRowMapper();
		
		for(AssessmentBodyBatchesDto x:ab)
		{
			Date da=x.getAssessmentDate();
			Date d=new Date();
			if(d.after(da))
				
				pastBatches.add(x);
			else
				//upcoming 
				upcomingBatches.add(x);
		}
		
			HashMap<String, ArrayList<AssessmentBodyBatchesDto>> hmap= new HashMap<String, ArrayList<AssessmentBodyBatchesDto>>();
			hmap.put("pastBatches", pastBatches);
			hmap.put("upcomingBatches", upcomingBatches);
					
		return hmap;
		
		
		
		
	}
}

       