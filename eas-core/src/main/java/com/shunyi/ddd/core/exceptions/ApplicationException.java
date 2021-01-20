package com.shunyi.ddd.core.exceptions;

/**
 * @author zhang
 * @create 2021-01-13 10:30
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message,Exception ex) {
        super(message,ex);
    }
}