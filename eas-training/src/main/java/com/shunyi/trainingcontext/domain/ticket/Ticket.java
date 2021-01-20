package com.shunyi.trainingcontext.domain.ticket;

import com.shunyi.ddd.core.stereotype.Aggregate;
import com.shunyi.trainingcontext.domain.candidate.Candidate;
import com.shunyi.trainingcontext.domain.exceptions.TicketException;
import com.shunyi.trainingcontext.domain.tickethistory.OperationType;
import com.shunyi.trainingcontext.domain.tickethistory.StateTransit;
import com.shunyi.trainingcontext.domain.tickethistory.TicketHistory;
import com.shunyi.trainingcontext.domain.training.TrainingId;

import java.time.LocalDateTime;

/**
 * @author zhang
 * @create 2021-01-12 09:19
 */
@Aggregate
public class Ticket {
    private TicketId     id;
    private TrainingId   trainingId;
    private TicketStatus ticketStatus;
    private String       nomineeId;

    public Ticket(TicketId id, TrainingId trainingId) {
        this(id, trainingId, TicketStatus.Available, null);
    }

    public Ticket(TicketId id, TrainingId trainingId, TicketStatus ticketStatus) {
        this(id, trainingId, ticketStatus, null);
    }

    public Ticket(TicketId id, TrainingId trainingId, TicketStatus ticketStatus, String nomineeId) {
        this.id = id;
        this.trainingId = trainingId;
        this.ticketStatus = ticketStatus;
        this.nomineeId = nomineeId;
    }

    public TicketHistory nominate(Candidate candidate, Nominator nominator) {
        validateTickStatus();
        doNomination(candidate);
        return generateHistory(candidate, nominator);
    }

    private TicketHistory generateHistory(Candidate candidate, Nominator nominator) {
        return new TicketHistory(id,
                candidate.toOwner(),
                transitState(),
                OperationType.Nomination,
                nominator.toOperator(),
                LocalDateTime.now());
    }

    private void doNomination(Candidate candidate) {
        this.ticketStatus = TicketStatus.WaitForConfirm;
        this.nomineeId = candidate.employeeId();
    }

    private void validateTickStatus() {
        if (!ticketStatus.isAvailable()) {
            throw new TicketException("ticket is not available,cannot be nominated.");
        }
    }

    public TicketId id() {
        return this.id;
    }

    public TrainingId trainingId() {
        return this.trainingId;
    }

    public TicketStatus status() {
        return this.ticketStatus;
    }

    public String nomineeId() {
        return this.nomineeId;
    }

    private StateTransit transitState() {
        return StateTransit.from(TicketStatus.Available).to(this.ticketStatus);
    }

    public String url() {
        return String.format("http://www.eas.com/eas/tickets/%s", this.id().value());
    }
}