package com.shunyi.trainingcontext.domain.notification;

import com.shunyi.trainingcontext.domain.course.CourseId;
import com.shunyi.trainingcontext.domain.ticket.Nominator;
import com.shunyi.trainingcontext.domain.ticket.Nominee;
import com.shunyi.trainingcontext.domain.ticket.Ticket;
import com.shunyi.trainingcontext.domain.ticket.TicketId;
import com.shunyi.trainingcontext.domain.ticket.TrainingRole;
import com.shunyi.trainingcontext.domain.training.Training;
import com.shunyi.trainingcontext.domain.training.TrainingId;
import com.shunyi.trainingcontext.domain.validdate.ValidDate;
import com.shunyi.trainingcontext.domain.validdate.ValidDateType;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MailTemplateTest {

    @Test
    public void should_compose_nomination_notification_given_ticket_and_nominator_and_nominee() {
        //given
        Nominator nominator = createNominator();
        Nominee   nominee = createNominee();
        TrainingId trainingId = TrainingId.next();
        Training training = createTraining(trainingId);
        ValidDate validDate = createValidDate(trainingId);
        Ticket    ticket    = createTicket();

        String template = buildTemplate();
        VariableContext context = buildVariableContext(nominator, nominee, validDate, training, ticket);

        MailTemplate mailTemplate = new MailTemplate(template, TemplateType.Nomination);

        //when
        Notification notification = mailTemplate.compose(context);

        //then
        assertThat(notification.from()).isEqualTo("admin@eas.com");
        assertThat(notification.to()).isEqualTo(nominee.email());
        assertThat(notification.subject()).isEqualTo("Ticket Nomination Notification");
        assertNotificationBody(nominator, nominee, validDate, training, ticket, notification);
    }

    private Nominator createNominator() {
        return new Nominator("200901010010", "bruce", "bruce@eas.com", TrainingRole.Coordinator);
    }

    private Training createTraining(TrainingId trainingId) {
        CourseId courseId = CourseId.next();
        LocalDateTime beginTime = LocalDateTime.of(2020, 1, 8, 9, 0);
        LocalDateTime endTime = LocalDateTime.of(2020, 1, 9, 17, 0);
        String place = "London Room";
        return new Training(trainingId, "ddd", "ddd training", beginTime, endTime, place, courseId);
    }

    private Nominee createNominee() {
        return new Nominee("201001010011", "bruce", "bruce@eas.com");
    }

    private ValidDate createValidDate(TrainingId trainingId) {
        LocalDateTime poDeadLine = LocalDateTime.of(2019, 12, 20, 0, 0);
        return new ValidDate(trainingId, poDeadLine, ValidDateType.PODeadline);
    }

    private Ticket createTicket() {
        return new Ticket(TicketId.next(), TrainingId.next());
    }

    private String buildTemplate() {
        return "Hi $nomineeName$:\n" +
                "We are glad to notify that you are nominated by $nominatorName$ to attend the training. Please click the link as below to confirm this nomination before the deadline $deadline$:\n" +
                "$url$\n" +
                "\n" +
                "Here is the basic information of training:\n" +
                "Title: $title$\n" +
                "Description: $description$\n" +
                "Begin time: $beginTime$\n" +
                "End time: $endTime$\n" +
                "Place: $place$\n" +
                "\n" +
                "Thanks! We're excited to have you in the training.\n" +
                "EAS Team";
    }

    private VariableContext buildVariableContext(Nominator nominator, Nominee nominee, ValidDate validDate, Training training, Ticket ticket) {
        VariableContext context = new VariableContext();
        context.put("training", training);
        context.put("ticket", ticket);
        context.put("valid_date", validDate);
        context.put("nominator", nominator);
        context.put("nominee", nominee);
        return context;
    }

    private void assertNotificationBody(Nominator nominator, Nominee nominee, ValidDate validDate, Training training, Ticket ticket, Notification notification) {
        assertThat(notification.body()).containsIgnoringCase(String.format("Hi %s:", nominee.name()));
        assertThat(notification.body()).containsIgnoringCase(String.format("you are nominated by %s to attend the training", nominator.name()));
        assertThat(notification.body()).containsIgnoringCase(String.format("the deadline %s", validDate.deadline()));
        assertThat(notification.body()).containsIgnoringCase(ticket.url());
        assertThat(notification.body()).containsIgnoringCase(String.format("Title: %s", training.title()));
        assertThat(notification.body()).containsIgnoringCase(String.format("Description: %s", training.description()));
        assertThat(notification.body()).containsIgnoringCase(String.format("Begin time: %s", training.beginTime()));
        assertThat(notification.body()).containsIgnoringCase(String.format("End time: %s", training.endTime()));
        assertThat(notification.body()).containsIgnoringCase(String.format("Place: %s", training.place()));
    }
}