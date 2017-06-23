package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by shubham on 6/20/17.
 */
@Component
@ConfigurationProperties(prefix = "assessmentBodyUpdateTable", locations = "classpath:sql/assessmentBodyUpdateTable.yml")
public class AssessmentBodyUpcomingBatchConfigSql {

    private String selectSql;

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }
}
