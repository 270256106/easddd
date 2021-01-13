package com.shunyi.trainingcontext.domain.notification;


import java.util.UUID;

/**
 * @author zhang
 * @create 2021-01-08 17:59
 */
public class MailTemplate {
    private String       id;
    private String       template;
    private TemplateType templateType;

    public MailTemplate(String template, TemplateType templateType) {
        this.id = UUID.randomUUID().toString();
        this.template = template;
        this.templateType = templateType;
    }

    public Notification compose(VariableContext context) {
        NotificationComposer notificationComposer = this.templateType.composer(template, context);
        return notificationComposer.compose();
    }
}