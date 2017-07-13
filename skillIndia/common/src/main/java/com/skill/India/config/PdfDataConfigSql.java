package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@Component
@ConfigurationProperties(prefix = "pdfData", locations = "classpath:sql/pdfData.yml")
public class PdfDataConfigSql {
    private String selectSql;

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }
}
