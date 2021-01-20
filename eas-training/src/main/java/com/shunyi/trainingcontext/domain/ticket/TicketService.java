package com.shunyi.trainingcontext.domain.ticket;

import com.shunyi.ddd.core.stereotype.DomainService;
import com.shunyi.trainingcontext.acl.ports.repositories.CandidateRepository;
import com.shunyi.trainingcontext.acl.ports.repositories.TicketHistoryRepository;
import com.shunyi.trainingcontext.acl.ports.repositories.TicketRepository;
import com.shunyi.trainingcontext.domain.candidate.Candidate;
import com.shunyi.trainingcontext.domain.exceptions.TicketException;
import com.shunyi.trainingcontext.domain.tickethistory.TicketHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhang
 * @create 2021-01-12 09:18
 */
@Service
@DomainService
public class TicketService {
    @Autowired
    private TicketRepository        tickRepo;
    @Autowired
    private TicketHistoryRepository ticketHistoryRepo;
    @Autowired
    private CandidateRepository     candidateRepo;

    public Ticket nominate(TicketId ticketId, Nominator nominator, Candidate candidate) {
        Optional<Ticket> optionalTicket = tickRepo.ticketOf(ticketId, TicketStatus.Available);
        Ticket           ticket         = optionalTicket.orElseThrow(() -> availableTicketNotFound(ticketId));

        TicketHistory ticketHistory = ticket.nominate(candidate, nominator);

        tickRepo.update(ticket);
        ticketHistoryRepo.add(ticketHistory);
        candidateRepo.remove(candidate);

        return ticket;
    }

    private TicketException availableTicketNotFound(TicketId ticketId) {
        return new TicketException(String.format("available ticket by id {%s} is not found.", ticketId));
    }

    public void setTicketRepository(TicketRepository tickRepo) {
        this.tickRepo = tickRepo;
    }

    public void setTicketHistoryRepository(TicketHistoryRepository ticketHistoryRepository) {
        this.ticketHistoryRepo = ticketHistoryRepository;
    }

    public void setCandidateRepository(CandidateRepository candidateRepository) {
        this.candidateRepo = candidateRepository;
    }
}