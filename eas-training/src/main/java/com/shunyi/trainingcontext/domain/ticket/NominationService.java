package com.shunyi.trainingcontext.domain.ticket;

import com.shunyi.trainingcontext.domain.candidate.Candidate;
import com.shunyi.trainingcontext.domain.exceptions.NominationException;
import com.shunyi.trainingcontext.domain.leaming.LearningService;
import com.shunyi.trainingcontext.domain.notification.NotificationService;
import com.shunyi.trainingcontext.domain.training.TrainingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang
 * @create 2021-01-12 09:19
 */
@Service
public class NominationService {

    @Autowired
    private LearningService     learningService;
    @Autowired
    private TicketService       ticketService;
    @Autowired
    private NotificationService notificationService;

    public void setLearningService(LearningService learningService) {
        this.learningService = learningService;
    }

    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void nominate(TicketId ticketId, TrainingId trainingId, Candidate candidate, Nominator nominator) {
        boolean belearned = learningService.beLearned(candidate.employeeId(), trainingId);
        if (belearned) {
            throw new NominationException(String.format("can not nominate the candidate %s who had learned in the training", candidate.name()));
        }
        Ticket ticket = ticketService.nominate(ticketId, nominator, candidate);
        notificationService.notifyNominee(ticket, nominator, candidate.toNominee());
    }
}