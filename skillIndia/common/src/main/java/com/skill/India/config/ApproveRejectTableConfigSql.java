package com.skill.India.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="approveReject",locations="classpath:sql/approveReject.yml")
public class ApproveRejectTableConfigSql {

	 private String selectSql;
	
	 private String updateSql;
	 
	 private String insertSql;
	 

    public String getSelectSql() {
        return selectSql;
    }
    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }

	
    
    public String getUpdateSql() {
		return updateSql;
	}
	public void setUpdateSql(String updateSql) {
		this.updateSql = updateSql;
	}
	

	
	/**
	 * @return the insertSql
	 */
	public String getInsertSql() {
		return insertSql;
	}

	/**
	 * @param insertSql the insertSql to set
	 */
	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}
}
