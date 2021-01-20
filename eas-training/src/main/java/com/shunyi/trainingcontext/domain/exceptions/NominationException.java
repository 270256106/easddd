package com.shunyi.trainingcontext.domain.exceptions;


import com.shunyi.ddd.core.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-12 15:26
 */
public class NominationException extends DomainException {
    public NominationException(String message) {
        super(message);
    }
}