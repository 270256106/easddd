package com.shunyi.ddd.eas.employeecontext.domain.employee;

/**
 * @author zhang
 * @create 2021-01-05 15:27
 */
public enum Gender {
    Male,Female;

    public boolean isMale() {
        return this == Male;
    }

    public boolean isFemale() {
        return this == Female;
    }
}