package com.skill.India.dto;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
public class DataBeanDto {
    private final String name;
    private final String city;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public DataBeanDto(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }
}
