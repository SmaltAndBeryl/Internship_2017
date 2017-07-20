package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Component
@ConfigurationProperties(prefix = "dropdown", locations = "classpath:sql/dropdown.yml")
public class DropdownConfigSql {
    private String selectSql;

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }
}
