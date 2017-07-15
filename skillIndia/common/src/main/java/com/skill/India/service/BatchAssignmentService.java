package com.skill.India.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skill.India.dao.BatchAssignmentDao;
import com.skill.India.dto.BatchAssignmentDto;


@Service
public class BatchAssignmentService {
	
	@Autowired
	private BatchAssignmentDao batchAssignmentDao;
	
	
	public Collection<BatchAssignmentDto> getproposedBatchesBatchAssignmentRowMapper(){
		return batchAssignmentDao.getproposedBatchesBatchAssignmentRowMapper();
	}
	
	public Collection<BatchAssignmentDto> getapprovedBatchesBatchAssignmentRowMapper (){
		return batchAssignmentDao.getapprovedBatchesBatchAssignmentRowMapper();
	}
	
	public Collection<BatchAssignmentDto> getrejectedBatchesBatchAssignmentRowMapper(){
		return batchAssignmentDao.getrejectedBatchesBatchAssignmentRowMapper();
	}

	
}
