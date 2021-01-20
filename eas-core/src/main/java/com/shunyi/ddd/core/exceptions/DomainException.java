package com.shunyi.ddd.core.exceptions;

/**
 * @author zhang
 * @create 2021-01-05 11:02
 */
public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

}