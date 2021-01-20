package com.shunyi.trainingcontext.domain.candidate;

import com.shunyi.ddd.core.stereotype.Aggregate;
import com.shunyi.trainingcontext.domain.ticket.Nominee;
import com.shunyi.trainingcontext.domain.tickethistory.TicketOwner;
import com.shunyi.trainingcontext.domain.tickethistory.TicketOwnerType;
import com.shunyi.trainingcontext.domain.training.TrainingId;

import java.util.UUID;

/**
 * @author zhang
 * @create 2021-01-12 15:27
 */
@Aggregate
public class Candidate {
    private String     id;
    private String     employeeId;
    private String     name;
    private String     email;
    private TrainingId trainingId;

    public Candidate(String employeeId, String name, String email, TrainingId trainingId) {
        this.id = UUID.randomUUID().toString();
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.trainingId = trainingId;
    }

    public String employeeId() {
        return this.employeeId;
    }

    public String name() {
        return this.name;
    }

    public String email() {
        return this.email;
    }

    public TrainingId trainingId() {
        return this.trainingId;
    }

    public TicketOwner toOwner() {
        return new TicketOwner(employeeId, TicketOwnerType.Nominee);
    }

    public Nominee toNominee() {
        return new Nominee(employeeId, name, email);
    }
}