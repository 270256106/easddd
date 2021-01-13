package com.shunyi.trainingcontext.domain.ticket;

/**
 * @author zhang
 * @create 2021-01-12 09:18
 */
public enum TicketStatus {
    Available, WaitForConfirm, Confirm;

    public boolean isAvailable() {
        return this == Available;
    }

    public boolean isWaitForConfirm() {
        return this == WaitForConfirm;
    }
}