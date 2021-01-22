package com.shunyi.projectcontext.domain.exception;

import com.shunyi.ddd.core.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-22 14:12
 */
public class IssueException extends DomainException {
    public IssueException(String message) {
        super(message);
    }
}