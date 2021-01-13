package com.shunyi.trainingcontext.domain.notification;

import com.shunyi.trainingcontext.domain.ticket.Nominator;
import com.shunyi.trainingcontext.domain.ticket.Nominee;
import com.shunyi.trainingcontext.domain.ticket.Ticket;
import com.shunyi.trainingcontext.domain.training.Training;
import com.shunyi.trainingcontext.domain.validdate.ValidDate;

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
        super.setup(context);
    }

    @Override
    protected List<TemplateVariable> registerVaiables() {
        return null;
    }

    @Override
    protected String renderSubject() {
        return null;
    }

    @Override
    protected String renderTo() {
        return null;
    }

    @Override
    protected String renderFrom() {
        return null;
    }
}