package com.shunyi.ddd.eas.employeecontext.domain.exceptions;


import com.shunyi.ddd.core.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-05 11:47
 */
public class InvalidEmployeeIdException extends DomainException {
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}