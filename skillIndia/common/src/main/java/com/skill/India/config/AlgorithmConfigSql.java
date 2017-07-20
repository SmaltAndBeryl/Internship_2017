package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Component
@ConfigurationProperties(prefix = "algorithm", locations = "classpath:sql/algorithm.yml")
public class AlgorithmConfigSql {

    private String getBatchIdSelectSql;
    private String getAgencyIdSelectSql;
    private String getAssessorIdSelectSql;

    public String getGetAssessorIdSelectSql() {
        return getAssessorIdSelectSql;
    }

    public void setGetAssessorIdSelectSql(String getAssessorIdSelectSql) {
        this.getAssessorIdSelectSql = getAssessorIdSelectSql;
    }

    public String getGetAgencyIdSelectSql() {
        return getAgencyIdSelectSql;
    }

    public void setGetAgencyIdSelectSql(String getAgencyIdSelectSql) {
        this.getAgencyIdSelectSql = getAgencyIdSelectSql;
    }

    public String getGetBatchIdSelectSql() {
        return getBatchIdSelectSql;
    }

    public void setGetBatchIdSelectSql(String getBatchIdSelectSql) {
        this.getBatchIdSelectSql = getBatchIdSelectSql;
    }
}
