package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by shubham on 6/20/17.
 */
@Component
@ConfigurationProperties(prefix = "assessmentBodyBatches", locations = "classpath:sql/assessmentBodyBatches.yml")
public class AssessmentBodyBatchesConfigSql {

    private String selectSql;

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }

}
