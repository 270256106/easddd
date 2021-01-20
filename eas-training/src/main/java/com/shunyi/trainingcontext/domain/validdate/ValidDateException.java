package com.shunyi.trainingcontext.domain.validdate;


import com.shunyi.ddd.core.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-12 13:49
 */
public class ValidDateException extends DomainException {
    public ValidDateException(String message) {
        super(message);
    }
}