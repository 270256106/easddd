package com.shunyi.attendancecontext.domain.exceptions;

import com.shunyi.ddd.core.domain.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-07 14:59
 */
public class InvalidAttendanceException extends DomainException {
    public InvalidAttendanceException(String message) {
        super(message);
    }
}