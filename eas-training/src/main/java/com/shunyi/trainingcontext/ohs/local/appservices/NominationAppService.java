package com.shunyi.trainingcontext.ohs.local.appservices;

import com.shunyi.ddd.core.application.exceptions.ApplicationException;
import com.shunyi.ddd.core.application.exceptions.ApplicationInfrastructureException;
import com.shunyi.ddd.core.application.exceptions.ApplicationValidationException;
import com.shunyi.ddd.core.domain.exceptions.DomainException;
import com.shunyi.trainingcontext.domain.ticket.NominationService;
import com.shunyi.trainingcontext.ohs.local.pl.NominatingCandidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author zhang
 * @create 2021-01-12 17:54
 */
@Service
@EnableTransactionManagement
public class NominationAppService {

    @Autowired
    private NominationService nominationService;

    @Transactional(rollbackFor = ApplicationException.class)
    public void nominate(NominatingCandidateRequest nominatingCandidateRequest) {
        if (Objects.isNull(nominatingCandidateRequest)) {
            throw new ApplicationValidationException("nomination request can not be null");
        }
        try {
            nominationService.nominate(
                    nominatingCandidateRequest.getTicketId(),
                    nominatingCandidateRequest.getTrainingId(),
                    nominatingCandidateRequest.toCandidate(),
                    nominatingCandidateRequest.toNominator()
            );
        } catch (DomainException exception) {
            throw new ApplicationException(exception.getMessage(), exception);
        } catch (Exception ex) {
            throw new ApplicationInfrastructureException("Infrastructure Error", ex);
        }
    }
}