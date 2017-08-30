package com.skill.India.dto;

public class UserRoleApplicationIdDto {
    private final String userRole;
    private final String applicationId;

    public String getUserRole() {
        return userRole;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public UserRoleApplicationIdDto(String userRole, String applicationId) {
        this.userRole = userRole;
        this.applicationId = applicationId;
    }
}
