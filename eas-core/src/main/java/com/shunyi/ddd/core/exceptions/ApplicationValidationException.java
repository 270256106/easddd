package com.shunyi.ddd.core.exceptions;

/**
 * @author zhang
 * @create 2021-01-13 10:31
 */
public class ApplicationValidationException extends ApplicationException{
    public ApplicationValidationException(String message) {
        super(message);
    }
}