package com.shunyi.projectcontext.domain.exception;

import com.shunyi.ddd.core.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-22 14:11
 */
public class AssignmentIssueException extends DomainException {
    public AssignmentIssueException(String message) {
        super(message);
    }
}