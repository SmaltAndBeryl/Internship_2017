package com.skill.India.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="importHistory",locations="classpath:sql/importHistory.yml")
public class DataImportHistoryConfigSql {

	private String selectSql;

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }

}
