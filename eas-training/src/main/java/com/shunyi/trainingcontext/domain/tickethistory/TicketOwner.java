package com.shunyi.trainingcontext.domain.tickethistory;

import java.util.Objects;

/**
 * @author zhang
 * @create 2021-01-12 13:48
 */
public class TicketOwner {
    private String          employeeId;
    private TicketOwnerType ownerType;

    public TicketOwner(String employeeId, TicketOwnerType ownerType) {
        this.employeeId = employeeId;
        this.ownerType = ownerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, ownerType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TicketOwner ticketOwner = (TicketOwner) obj;
        return employeeId.equals(ticketOwner.employeeId) &&
                ownerType == ticketOwner.ownerType;
    }
}