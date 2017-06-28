package com.skill.India.dto;
import com.skill.India.common.BaseDto;
public class ShowInterestUpcomingBatchesDto extends BaseDto{
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String batch_id ;
        
    public ShowInterestUpcomingBatchesDto(String id, String batch_id ) {
    	super();
    	this.id = id;
    	this.batch_id = batch_id;     
 }

    public String getId() {
    	return id;
     }

    public String getBatch_id() {
    	return batch_id;
 }
}