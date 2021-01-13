package com.shunyi.trainingcontext.domain.notification;

import com.shunyi.ddd.core.domain.exceptions.DomainException;

/**
 * @author zhang
 * @create 2021-01-12 15:33
 */
public class MailTemplateException extends DomainException {
    public MailTemplateException(String message) {
        super(message);
    }
}