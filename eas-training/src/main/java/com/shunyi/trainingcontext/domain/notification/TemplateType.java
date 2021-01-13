package com.shunyi.trainingcontext.domain.notification;

/**
 * @author zhang
 * @create 2021-01-08 18:00
 */
public enum TemplateType {
    Nomination {
        @Override
        public NotificationComposer composer(String template, VariableContext context) {
            return new NominationNotificationComposer(template, context);
        }
    };

    abstract NotificationComposer composer(String template, VariableContext context);
}