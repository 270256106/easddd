package com.shunyi.trainingcontext.domain.training;


import com.shunyi.ddd.core.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-12 09:13
 */
public class TrainingException extends DomainException {
    public TrainingException(String message) {
        super(message);
    }
}