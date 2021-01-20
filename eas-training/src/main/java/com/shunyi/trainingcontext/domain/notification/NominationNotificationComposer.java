package com.shunyi.trainingcontext.domain.notification;

import com.shunyi.trainingcontext.domain.ticket.Nominator;
import com.shunyi.trainingcontext.domain.ticket.Nominee;
import com.shunyi.trainingcontext.domain.ticket.Ticket;
import com.shunyi.trainingcontext.domain.training.Training;
import com.shunyi.trainingcontext.domain.validdate.ValidDate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang
 * @create 2021-01-11 16:18
 */
public class NominationNotificationComposer extends NotificationComposer {
    private Training  training;
    private Ticket    ticket;
    private ValidDate validDate;
    private Nominator nominator;
    private Nominee   nominee;

    public NominationNotificationComposer(String template, VariableContext context) {
        super(template, context);
    }

    @Override
    protected void setup(VariableContext context) {
        training = context.get("training");
        ticket = context.get("ticket");
        validDate = context.get("valid_date");
        nominator = context.get("nominator");
        nominee = context.get("nominee");
    }

    @Override
    protected List<TemplateVariable> registerVariables() {
        List<TemplateVariable> variables = new ArrayList<>();
        variables.add(TemplateVariable.with("nomineeName", nominee.name()));
        variables.add(TemplateVariable.with("nominatorName", nominator.name()));
        variables.add(TemplateVariable.with("url", ticket.url()));
        variables.add(TemplateVariable.with("title", training.title()));
        variables.add(TemplateVariable.with("description", training.description()));
        variables.add(TemplateVariable.with("beginTime", training.beginTime().toString()));
        variables.add(TemplateVariable.with("endTime", training.endTime().toString()));
        variables.add(TemplateVariable.with("place", training.place()));
        variables.add(TemplateVariable.with("deadline", validDate.deadline().toString()));
        return variables;
    }

    @Override
    protected String renderSubject() {
        return "Ticket Nomination Notification";
    }

    @Override
    protected String renderTo() {
        return nominee.email();
    }

    @Override
    protected String renderFrom() {
        return "admin@eas.com";
    }
}