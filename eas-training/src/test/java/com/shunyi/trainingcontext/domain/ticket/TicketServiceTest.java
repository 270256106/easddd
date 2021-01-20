package com.shunyi.trainingcontext.domain.ticket;

import com.shunyi.trainingcontext.acl.ports.repositories.CandidateRepository;
import com.shunyi.trainingcontext.acl.ports.repositories.TicketHistoryRepository;
import com.shunyi.trainingcontext.acl.ports.repositories.TicketRepository;
import com.shunyi.trainingcontext.domain.candidate.Candidate;
import com.shunyi.trainingcontext.domain.exceptions.TicketException;
import com.shunyi.trainingcontext.domain.tickethistory.TicketHistory;
import com.shunyi.trainingcontext.domain.training.TrainingId;
import org.junit.Test;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TicketServiceTest {


    @Test
    public void should_nominate_candidate_for_specific_ticket() {
        //given
        TrainingId trainingId = TrainingId.next();
        TicketId ticketId = TicketId.next();
        Ticket ticket = new Ticket(TicketId.next(), trainingId, TicketStatus.Available);

        TicketRepository mockTicketRepo = mock(TicketRepository.class);
        when(mockTicketRepo.ticketOf(ticketId, TicketStatus.Available)).thenReturn(Optional.of(ticket));

        TicketHistoryRepository mockTicketHistoryRepo = mock(TicketHistoryRepository.class);
        CandidateRepository mockCandidateRepo = mock(CandidateRepository.class);

        TicketService ticketService = new TicketService();
        ticketService.setTicketRepository(mockTicketRepo);
        ticketService.setTicketHistoryRepository(mockTicketHistoryRepo);
        ticketService.setCandidateRepository(mockCandidateRepo);

        Candidate candidate = new Candidate("200901010110", "Tom", "tom@eas.com", trainingId);
        Nominator nominator = new Nominator("200901010007", "admin", "admin@eas.com", TrainingRole.Coordinator);

        //when
        Ticket nominatedTicket = ticketService.nominate(ticketId, nominator, candidate);

        //then
        assertThat(nominatedTicket.status().isWaitForConfirm()).isTrue();
        verify(mockTicketRepo).ticketOf(ticketId, TicketStatus.Available);
        verify(mockTicketRepo).update(ticket);
        verify(mockTicketHistoryRepo).add(isA(TicketHistory.class));
        verify(mockCandidateRepo).remove(candidate);
    }

    @Test
    public void should_throw_TicketException_if_available_ticket_not_found() {
        TicketId ticketId = TicketId.next();
        TicketRepository mockTicketRepo = mock(TicketRepository.class);
        when(mockTicketRepo.ticketOf(ticketId, TicketStatus.Available)).thenReturn(Optional.empty());

        TicketService ticketService = new TicketService();
        ticketService.setTicketRepository(mockTicketRepo);

        Candidate candidate = new Candidate("200901010110", "Tom", "tom@eas.com", TrainingId.next());
        Nominator nominator = new Nominator("200901010007", "admin", "admin@eas.com", TrainingRole.Coordinator);

        assertThatThrownBy(() -> ticketService.nominate(ticketId, nominator, candidate))
                .isInstanceOf(TicketException.class)
                .hasMessageContaining(String.format("available ticket by id {%s} is not found", ticketId.value()));
        verify(mockTicketRepo).ticketOf(ticketId, TicketStatus.Available);
    }
}