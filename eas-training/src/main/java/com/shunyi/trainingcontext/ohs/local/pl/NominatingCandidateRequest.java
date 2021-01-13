package com.shunyi.trainingcontext.ohs.local.pl;

import com.shunyi.trainingcontext.domain.candidate.Candidate;
import com.shunyi.trainingcontext.domain.ticket.Nominator;
import com.shunyi.trainingcontext.domain.ticket.TicketId;
import com.shunyi.trainingcontext.domain.ticket.TrainingRole;
import com.shunyi.trainingcontext.domain.training.TrainingId;

import java.io.Serializable;

/**
 * @author zhang
 * @create 2021-01-12 17:55
 */
public class NominatingCandidateRequest implements Serializable {
    private String ticketId;
    private String trainingId;
    private String candidateId;
    private String candidateName;
    private String candidateEmail;
    private String nominatorId;
    private String nominatorName;
    private String nominatorEmail;
    private TrainingRole trainingRole;

    public NominatingCandidateRequest() {
    }

    public NominatingCandidateRequest(String ticketId, String trainingId, String candidateId, String candidateName, String candidateEmail, String nominatorId, String nominatorName, String nominatorEmail, TrainingRole trainingRole) {
        this.ticketId = ticketId;
        this.trainingId = trainingId;
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.candidateEmail = candidateEmail;
        this.nominatorId = nominatorId;
        this.nominatorName = nominatorName;
        this.nominatorEmail = nominatorEmail;
        this.trainingRole = trainingRole;
    }

    public TicketId getTicketId() {
        return TicketId.from(ticketId) ;
    }

    public TrainingId getTrainingId() {
        return TrainingId.from(trainingId);
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public String getNominatorId() {
        return nominatorId;
    }

    public String getNominatorName() {
        return nominatorName;
    }

    public String getNominatorEmail() {
        return nominatorEmail;
    }

    public TrainingRole getTrainingRole() {
        return trainingRole;
    }

    public Candidate toCandidate() {
        return new Candidate(candidateId, candidateName, candidateEmail, TrainingId.from(trainingId));
    }

    public Nominator toNominator() {
        return new Nominator(nominatorId, nominatorName, nominatorEmail, trainingRole);
    }
}