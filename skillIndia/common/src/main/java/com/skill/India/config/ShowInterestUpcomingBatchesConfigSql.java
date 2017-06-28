package com.skill.India.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
	@Component
	@ConfigurationProperties(prefix = "ShowInterest", locations = "classpath:sql/ShowInterest.yml")
	public class ShowInterestUpcomingBatchesConfigSql 
	
	{

	    private String insertSql;

	    public String getinsertSql() {
	        return insertSql;
	    }

	    public void setinsertSql(String insertSql) {
	        this.insertSql = insertSql;
	    }
	}


	
