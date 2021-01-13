package com.shunyi.trainingcontext.domain.tickethistory;

import com.shunyi.trainingcontext.domain.ticket.TicketId;
import com.shunyi.trainingcontext.domain.ticket.TicketStatus;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author zhang
 * @create 2021-01-12 13:48
 */
public class TicketHistory {
    private String        id;
    private TicketId      ticketId;
    private TicketOwner   owner;
    private StateTransit  stateTransit;
    private OperationType operationType;
    private Operator      operatorBy;
    private LocalDateTime operatedAt;

    public TicketHistory(String id,
                         TicketId ticketId,
                         TicketOwner owner,
                         StateTransit stateTransit,
                         OperationType operationType,
                         Operator operatorBy,
                         LocalDateTime operatedAt) {
        this.id = id;
        this.ticketId = ticketId;
        this.owner = owner;
        this.stateTransit = stateTransit;
        this.operationType = operationType;
        this.operatorBy = operatorBy;
        this.operatedAt = operatedAt;
    }

    public TicketHistory(TicketId ticketId,
                         TicketOwner owner,
                         StateTransit stateTransit,
                         OperationType operationType,
                         Operator operatorBy,
                         LocalDateTime operatedAt) {
        this(UUID.randomUUID().toString(), ticketId, owner, stateTransit, operationType, operatorBy, operatedAt);
    }

    public TicketHistory(String id,
                         TicketId ticketId,
                         String ownerId,
                         TicketOwnerType ownerType,
                         TicketStatus fromStatus,
                         TicketStatus toStatus,
                         OperationType operationType,
                         String operatorId,
                         String operatorName,
                         LocalDateTime operatedAt) {
        this.id = id;
        this.ticketId = ticketId;
        this.owner = new TicketOwner(ownerId, ownerType);
        this.stateTransit = StateTransit.from(fromStatus).to(toStatus);
        this.operationType = operationType;
        this.operatorBy = new Operator(operatorId, operatorName);
        this.operatedAt = operatedAt;
    }

    public TicketId ticketId() {
        return this.ticketId;
    }

    public TicketOwner owner() {
        return this.owner;
    }

    public StateTransit stateTransit() {
        return this.stateTransit;
    }

    public OperationType operationType() {
        return this.operationType;
    }

    public Operator operatorBy() {
        return this.operatorBy;
    }

    public LocalDateTime operatedAt() {
        return this.operatedAt;
    }
}