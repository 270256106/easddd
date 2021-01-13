package com.shunyi.trainingcontext.domain.notification;

import org.stringtemplate.v4.ST;

import java.util.List;

/**
 * @author zhang
 * @create 2021-01-08 18:07
 */
public abstract class NotificationComposer {
    private static final char   BEGIN_VARIABLE = '$';
    private static final char   END_VARIABLE   = '$';
    protected            String template;

    public NotificationComposer(String template, VariableContext context) {
        this.template = template;
        setup(context);
    }

    protected void setup(VariableContext context) {

    }

    public Notification compose() {
        String from    = renderFrom();
        String to      = renderTo();
        String subject = renderSubject();
        String body    = renderBody();
        return new Notification(from, to, subject, body);
    }

    protected String renderBody() {
        List<TemplateVariable> variables = registerVaiables();
        ST                     st        = new ST(template, BEGIN_VARIABLE, END_VARIABLE);
        for (TemplateVariable variable : variables) {
            st.add(variable.name(), variable.value());
        }
        return st.render();
    }

    protected abstract List<TemplateVariable> registerVaiables();

    protected abstract String renderSubject();

    protected abstract String renderTo();

    protected abstract String renderFrom();

}