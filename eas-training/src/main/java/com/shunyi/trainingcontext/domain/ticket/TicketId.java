package com.shunyi.trainingcontext.domain.ticket;

import java.util.Objects;
import java.util.UUID;

/**
 * @author zhang
 * @create 2021-01-12 09:18
 */
public class TicketId {
    private String value;

    public TicketId(String value) {
        this.value = value;
    }

    public static TicketId next() {
        return new TicketId(UUID.randomUUID().toString());
    }

    public static TicketId from(String value) {
        return new TicketId(value);
    }

    public String value() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TicketId ticketId = (TicketId) obj;
        return value.equals(ticketId.value);
    }

    @Override
    public String toString() {
        return value;
    }
}