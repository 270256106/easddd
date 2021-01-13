package com.shunyi.ddd.core.application.exceptions;

/**
 * @author zhang
 * @create 2021-01-13 10:30
 */
public class ApplicationInfrastructureException extends ApplicationException{
    public ApplicationInfrastructureException(String message, Exception ex) {
        super(message, ex);
    }
}