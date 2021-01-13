package com.shunyi.trainingcontext.domain.notification;

import com.shunyi.trainingcontext.acl.ports.clients.NotificationClient;
import com.shunyi.trainingcontext.acl.ports.repositories.MailTemplateRepository;
import com.shunyi.trainingcontext.acl.ports.repositories.TrainingRepository;
import com.shunyi.trainingcontext.acl.ports.repositories.ValidDateRepository;
import com.shunyi.trainingcontext.domain.ticket.Nominator;
import com.shunyi.trainingcontext.domain.ticket.Nominee;
import com.shunyi.trainingcontext.domain.ticket.Ticket;
import com.shunyi.trainingcontext.domain.training.Training;
import com.shunyi.trainingcontext.domain.training.TrainingException;
import com.shunyi.trainingcontext.domain.validdate.ValidDate;
import com.shunyi.trainingcontext.domain.validdate.ValidDateException;
import com.shunyi.trainingcontext.domain.validdate.ValidDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhang
 * @create 2021-01-12 15:34
 */
@Service
public class NotificationService {
    @Autowired
    private MailTemplateRepository templateRepository;
    @Autowired
    private NotificationClient     notificationClient;
    @Autowired
    private TrainingRepository     trainingRepository;
    @Autowired
    private ValidDateRepository    validDateRepository;

    public void notifyNominee(Ticket ticket, Nominator nominator, Nominee nominee) {
        MailTemplate mailTemplate = retrieveMailTemplate();
        Training     training     = retrieveTraining(ticket);
        ValidDate    validDate    = retrieveValidDate(ticket);

        VariableContext variableContext = buildVariableContext(ticket, nominator, nominee, training, validDate);
        Notification    notification    = mailTemplate.compose(variableContext);

        notificationClient.send(notification);
    }

    private VariableContext buildVariableContext(Ticket ticket, Nominator nominator, Nominee nominee, Training training, ValidDate validDate) {
        VariableContext variableContext = new VariableContext();
        variableContext.put("ticket", ticket);
        variableContext.put("training", training);
        variableContext.put("valid_date", validDate);
        variableContext.put("nominator", nominator);
        variableContext.put("nominee", nominee);
        return variableContext;
    }

    private ValidDate retrieveValidDate(Ticket ticket) {
        Optional<ValidDate> optionalValidDate        = validDateRepository.validDateOf(ticket.trainingId(), ValidDateType.PODeadline);
        String              validDateNotFoundMessage = String.format("valid date by training id {%s} was not found.", ticket.trainingId());
        return optionalValidDate.orElseThrow(() -> new ValidDateException(validDateNotFoundMessage));
    }

    private Training retrieveTraining(Ticket ticket) {
        Optional<Training> optionalTraining        = trainingRepository.trainingOf(ticket.trainingId());
        String             trainingNotFoundMessage = String.format("training bby id {%s} was not found.", ticket.trainingId());
        return optionalTraining.orElseThrow(() -> new TrainingException(trainingNotFoundMessage));
    }

    private MailTemplate retrieveMailTemplate() {
        Optional<MailTemplate> optionalMailTemplate        = templateRepository.templateOf(TemplateType.Nomination);
        String                 mailTemplateNotFoundMessage = String.format("mail template by %s was not found.", TemplateType.Nomination);
        return optionalMailTemplate.orElseThrow(() -> new MailTemplateException(mailTemplateNotFoundMessage));
    }

    public void setTemplateRepository(MailTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public void setNotificationClient(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void setTrainingRepository(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public void setValidDateRepository(ValidDateRepository validDateRepository) {
        this.validDateRepository = validDateRepository;
    }
}