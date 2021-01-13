package com.shunyi.ddd.core.application.exceptions;

/**
 * @author zhang
 * @create 2021-01-13 10:30
 */
public class ApplicationDomainException extends ApplicationException{

    public ApplicationDomainException(String message, Exception ex) {
        super(message, ex);
    }
}