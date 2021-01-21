package com.shunyi.ddd.eas.employeecontext.domain.exceptions;


import com.shunyi.ddd.core.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-05 11:48
 */
public class InvalidEmployeeException extends DomainException {
    public InvalidEmployeeException(String message) {
        super(message);
    }
}