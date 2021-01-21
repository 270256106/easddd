package com.shunyi.ddd.eas.employeecontext.domain.exceptions;

import com.shunyi.ddd.core.exceptions.ApplicationException;

/**
 * @author zhang
 * @create 2021-01-21 13:12
 */
public class InvalidAttendanceException extends ApplicationException {
    public InvalidAttendanceException(String message) {
        super(message);
    }
}