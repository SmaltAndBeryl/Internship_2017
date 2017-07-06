package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "assessmentBodyApplicationStatus", locations = "classpath:sql/assessmentBodyApplicationStatus.yml")

public class AssessmentBodyApplicationStatusConfigSql {
	
	 private String selectSql;

	    public String getSelectSql() {
	        return selectSql;
	    }

	    public void setSelectSql(String selectSql) {
	        this.selectSql = selectSql;
	    }

}
