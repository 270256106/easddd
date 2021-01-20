package com.shunyi.trainingcontext.domain.ticket;

import com.shunyi.trainingcontext.domain.candidate.Candidate;
import com.shunyi.trainingcontext.domain.exceptions.NominationException;
import com.shunyi.trainingcontext.domain.leaning.LearningService;
import com.shunyi.trainingcontext.domain.notification.NotificationService;
import com.shunyi.trainingcontext.domain.training.TrainingId;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NominationServiceTest {

    @Test
    public void should_nominate_candidate_to_be_nominee() {
        //given
        TicketId ticketId = TicketId.next();
        TrainingId trainingId = TrainingId.next();
        Ticket ticket = new Ticket(ticketId, trainingId, TicketStatus.WaitForConfirm);
        Candidate candidate = new Candidate(("200901010007"), "admin", "admin@eas.com", trainingId);
        Nominator nominator = new Nominator("200901010007", "admin", "admin@eas.com", TrainingRole.Coordinator);

        LearningService mockLearningService = mock(LearningService.class);
        when(mockLearningService.beLearned(candidate.employeeId(), trainingId)).thenReturn(false);

        TicketService mockTicketService = mock(TicketService.class);
        when(mockTicketService.nominate(ticketId, nominator, candidate)).thenReturn(ticket);

        NotificationService mockNotificationService = mock(NotificationService.class);

        NominationService nominationService = new NominationService();
        nominationService.setLearningService(mockLearningService);
        nominationService.setTicketService(mockTicketService);
        nominationService.setNotificationService(mockNotificationService);

        //when
        nominationService.nominate(ticketId, trainingId, candidate, nominator);

        //then
        verify(mockLearningService).beLearned(candidate.employeeId(), trainingId);
        verify(mockTicketService).nominate(ticketId, nominator, candidate);
        verify(mockNotificationService).notifyNominee(ticket, nominator, candidate.toNominee());
    }

    @Test
    public void should_throw_NominationException_if_candidate_had_been_learned() {
        //given
        TicketId ticketId = TicketId.next();
        TrainingId trainingId = TrainingId.next();
        Ticket ticket = new Ticket(ticketId, trainingId, TicketStatus.WaitForConfirm);
        Candidate candidate = new Candidate(("200901010007"), "admin", "admin@eas.com", trainingId);
        Nominator nominator = new Nominator("200901010007", "admin", "admin@eas.com", TrainingRole.Coordinator);

        LearningService mockLearningService = mock(LearningService.class);
        when(mockLearningService.beLearned(candidate.employeeId(), trainingId)).thenReturn(true);

        TicketService mockTicketService = mock(TicketService.class);
        when(mockTicketService.nominate(ticketId, nominator, candidate)).thenReturn(ticket);

        NotificationService mockNotificationService = mock(NotificationService.class);

        NominationService nominationService = new NominationService();
        nominationService.setLearningService(mockLearningService);
        nominationService.setTicketService(mockTicketService);
        nominationService.setNotificationService(mockNotificationService);

        //when
        assertThatThrownBy(() -> nominationService.nominate(ticketId, trainingId, candidate, nominator))
                .isInstanceOf(NominationException.class)
                .hasMessageContaining(String.format("can not nominate the candidate %s who had learned in the training",candidate.name()));

        //then
        verify(mockLearningService).beLearned(candidate.employeeId(), trainingId);
        verify(mockTicketService,never()).nominate(ticketId, nominator, candidate);
        verify(mockNotificationService,never()).notifyNominee(ticket, nominator, candidate.toNominee());
    }
}