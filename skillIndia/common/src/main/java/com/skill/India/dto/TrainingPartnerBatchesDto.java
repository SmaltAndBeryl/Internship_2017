
package com.skill.India.dto;

import java.sql.Date;

import com.skill.India.common.BaseDto;

/**
 * @author Rachit Goyal
 *
 */
public class TrainingPartnerBatchesDto extends BaseDto{

	private static final long serialVersionUID = 1L;

    private final String batchId;
    private final Date completionDate;
    private final String instructorName;
    private final Integer noOfCandidates;
   

    public TrainingPartnerBatchesDto(String batchId, Date completionDate, String instructorName, Integer noOfCandidates) {
        super();
        this.batchId = batchId;
        this.completionDate = completionDate;
        this.instructorName = instructorName;
        this.noOfCandidates = noOfCandidates;
        
        
    }

    public String getBatchId() {
        return batchId;
        
    }
           
    public Date getCompletionDate() {
        return completionDate;
    }
    
    public String getInstructorName() {
        return instructorName;
    }
    
    public Integer getNoOfCandidates() {
        return noOfCandidates;
    }

}
