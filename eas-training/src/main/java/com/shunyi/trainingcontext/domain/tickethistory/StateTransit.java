package com.shunyi.trainingcontext.domain.tickethistory;

import com.shunyi.trainingcontext.domain.ticket.TicketStatus;

import java.util.Objects;

/**
 * @author zhang
 * @create 2021-01-12 13:48
 */
public class StateTransit {
    private TicketStatus from;
    private TicketStatus to;

    private StateTransit() {

    }

    public StateTransit(TicketStatus from, TicketStatus to) {
        this.from = from;
        this.to = to;
    }

    public static StateTransit from(TicketStatus from) {
        StateTransit stateTransit = new StateTransit();
        stateTransit.from = from;
        return stateTransit;
    }

    public StateTransit to(TicketStatus to) {
        this.to = to;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StateTransit that = (StateTransit) obj;
        return from == that.from &&
                to == that.to;
    }
}